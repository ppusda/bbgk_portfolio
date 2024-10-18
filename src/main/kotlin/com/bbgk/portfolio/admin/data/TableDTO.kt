package com.bbgk.portfolio.admin.data

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

class TableDTO(
        val name: String,
        val columns: List<String>,
        val records: List<List<String>>
) {
    companion object {
        fun <T: Any> from(classInfo: KClass<T>, entities: List<Any>, vararg filterings: String): TableDTO { // vararg, Java에서는 ... 가변인자
            val name = classInfo.simpleName ?: "Unknown"
            val columns = createColunms(classInfo, *filterings)
            val records = entities.map { entity ->
                columns.map { column ->
                    classInfo.memberProperties
                            .find { column.equals(it.name) }
                            ?.getter
                            ?.call(entity)
                            .toString()
                }.toList()
            }.toList()

            return TableDTO(name = name, columns = columns, records = records)
        }

        private fun <T : Any> createColunms(classInfo: KClass<T>, vararg filterings: String): MutableList<String> {
            val mainColums = classInfo.java.declaredFields
                    .filter { !filterings.contains(it.name) }
                    .map { it.name }
                    .toMutableList()

            val baseColumns = classInfo.java.superclass.declaredFields
                    .map { it.name }
                    .toMutableList()

            return (mainColums + baseColumns).toMutableList()
        }
    }


}