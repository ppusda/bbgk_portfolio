package com.bbgk.portfolio.domain

import com.bbgk.portfolio.domain.constant.SkillType
import com.bbgk.portfolio.domain.entity.*
import com.bbgk.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Slf4j
@Component
@Profile(value = ["default"])
class DataInitializer(
        private val achievementRepository: AchievementRepository,
        private val introductionRepository: IntroductionRepository,
        private val linkRepository: LinkRepository,
        private val skillRepository: SkillRepository,
        private val projectRepository: ProjectRepository,
        private val experienceRepository: ExperienceRepository
) {

    val log: Logger = LoggerFactory.getLogger(DataInitializer::class.java)
    @PostConstruct
    fun initializeData() {
        log.info("Portfolio project start. initialize Data.")

        // achievement 초기화
        val achievements = mutableListOf(
                Achievement(
                        title = "백엔드 스쿨 7기 우수 수료생",
                        description = "Java/Spring 기반 백엔드 부트캠프, 약 100명 중 4명 선정",
                        host = "멋쟁이사자처럼(테킷)",
                        achievedDate = LocalDate.of(2024, 4, 4),
                        isActive = true
                ),
                Achievement(
                        title = "정보처리산업기사",
                        description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                        host = "한국산업인력공단",
                        achievedDate = LocalDate.of(2020, 11, 12),
                        isActive = true
                ),
        )
        achievementRepository.saveAll(achievements)

        // introduction 초기화
        val introductions = mutableListOf<Introduction>(
                Introduction(content = "사용자를 위해 개발하며 함께 성장해나가는 개발자, 조동국 입니다.", isActive = true),
                Introduction(content = "만드는 것과 성취감을 얻는 것을 좋아해서 개발을 시작하게 되었습니다.", isActive = true),
                Introduction(content = "공부하는 과정에서 아두이노, 앱, 웹 등 다양한 분야에서 서비스를 만들어 보면서", isActive = true),
                Introduction(content = "개발뿐만이 아닌 사용자, 기획, 디자인 등 다양한 관점에서 생각하는 방법을 배웠습니다.", isActive = true),
                Introduction(content = "사용자에게 편리한 서비스를 지향하며, 어떤 문제든 도전하는 것을 좋아합니다.", isActive = true),
                Introduction(content = "도전하며 항상 배울 수 있다고 생각하고 그 과정에서 배운 것들을 공유하는 것을 즐깁니다.", isActive = true),
                Introduction(content = "사용자를 위한 서비스를 고민하고 개선해 나가며 동료들과 소통하며 문제를 해결해 나가는 개발자가 되고 싶습니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        // link 초기화
        val links = mutableListOf<Link>(
                Link(name = "Github", content = "https://github.com/ppusda", isActive = true),
                Link(name = "Blog", content = "https://ppusda.tistory.com", isActive = true),
        )
        linkRepository.saveAll(links)

        // experience / experience_detail 초기화
        val experience1 = Experience(
                title = "동양미래대학교",
                description = "컴퓨터정보공학과",
                startYear = 2019,
                startMonth = 3,
                endYear = 2021,
                endMonth = 2,
                isActive = true,
        )
        experience1.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "3.7/4.5", isActive = true),
                )
        )
        val experience2 = Experience(
                title = "인포보스",
                description = "솔루션개발팀",
                startYear = 2021,
                startMonth = 8,
                endYear = 2023,
                endMonth = 7,
                isActive = true,
        )
        experience2.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "생물정보 데이터 수집 프로그램 개발", isActive = true),
                        ExperienceDetail(content = "서버 모니터링 프로그램 개발", isActive = true)
                )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        // skill 초기화
        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val nestjs = Skill(name = "Nest.js (React)", type = SkillType.FRAMEWORK.name, isActive = true)
        val vuejs = Skill(name = "Vue.js", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val oracle = Skill(name = "Oracle", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        val jpa = Skill(name = "JPA", type = SkillType.TOOL.name, isActive = true)
        val docker = Skill(name = "Docker", type = SkillType.TOOL.name, isActive = true)
        val aws = Skill(name = "AWS", type = SkillType.TOOL.name, isActive = true)
        val ncp = Skill(name = "NCP", type = SkillType.TOOL.name, isActive = true)
        val linux = Skill(name = "Linux", type = SkillType.TOOL.name, isActive = true)

        skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, mysql, oracle, redis, jpa, docker, aws, ncp, linux))

        // project / project_detail / project_skill 초기화
        val project1 = Project(
                name = "생물정보 데이터 수집 프로그램 개발",
                description = "정제되지 않은 생물정보 데이터를 수집하는 프로그램 개발 및 정규화 하는 작업을 진행",
                startYear = 2021,
                startMonth = 8,
                endYear = 2023,
                endMonth = 7,
                isActive = true
        )
        project1.addDetails(
                mutableListOf(
                        ProjectDetail(content = "웹 크롤링에 적합한 Python과 Selenium, BS4를 활용하여 데이터 수집", url = null, isActive = true),
                        ProjectDetail(content = "Open API의 경우 데이터 접근이 잦고 쿼리 관리에 한계를 느껴, 쉽고 효율적인 접근을 위해 JPA 활용", url = null, isActive = true),
                        ProjectDetail(content = "약 800만건의 데이터 수집 및 데이터 정규화 작업 수행", url = null, isActive = true)
                )
        )
        project1.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project1, skill = java),
                        ProjectSkill(project = project1, skill = spring),
                        ProjectSkill(project = project1, skill = jpa),
                        ProjectSkill(project = project1, skill = python),
                        ProjectSkill(project = project1, skill = mysql)
                )
        )
        val project2 = Project(
                name = "서버 모니터링 프로그램 개발",
                description = "수정이 어려운 레거시 프로그램의 이슈를 빠르게 파악하여 안정적인 서비스를 제공할 수 있도록 모니터링 기능을 개발",
                startYear = 2022,
                startMonth = 6,
                endYear = 2022,
                endMonth = 12,
                isActive = true
        )
        project2.addDetails(
                mutableListOf(
                        ProjectDetail(content = "오픈소스 모니터링 툴을 고려하였으나, 직접 개발하는 쪽이 빠를 것으로 판단하여 직접 개발", url = null, isActive = true),
                        ProjectDetail(content = "알림 발송을 비동기 처리하여 이미지 분석 - 알림 발송 기능간 의존도 감소", url = null, isActive = true),
                )
        )
        project2.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project2, skill = python),
                        ProjectSkill(project = project2, skill = mysql)
                )
        )

        val project3 = Project(
                name = "COM,MA / 인디 작곡가를 지원하기 위한 음악 플랫폼",
                description = "작곡가들에게 음원 피드백과 홍보, 후원 기회를 제공하여 창작 활동을 지원하기 위해 개발",
                startYear = 2024,
                startMonth = 1,
                endYear = 2024,
                endMonth = 3,
                isActive = true
        )
        project3.addDetails(
                mutableListOf(
                        ProjectDetail(content = "음원 업로드 시 Presigned Url을 통해 클라이언트에서 업로드할 수 있도록 구현", url = null, isActive = true),
                        ProjectDetail(content = "업로드 속도를 5초에서 1.5초로 70% 개선", url = null, isActive = true),
                        ProjectDetail(content = "음원 업로드 후 인코딩 완료 Callback을 SSE, Redis로 전달하는 기능 개발", url = null, isActive = true),
                        ProjectDetail(content = "음원 인코딩이 완료된 후 음원을 등록하여 음원이 재생되지 않는 문제 해결", url = null, isActive = true),
                        ProjectDetail(content = "DefferredResult를 통한 비동기 처리 시, 요청 중에 완료된 인증 정보를 응답 시 확인할 수 없는 문제 발생", url = null, isActive = true),
                        ProjectDetail(content = "Spring Security 6 이후 변경사항에 따라 SecurityContextRepository를 지정하여 문제 해결",
                                url = "https://ppusda.tistory.com/83", isActive = true),
                        ProjectDetail(content = "Github Repository",
                                url = "https://github.com/Techit-Comma/Comma_Backend", isActive = true)
                )
        )
        project3.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project3, skill = java),
                        ProjectSkill(project = project3, skill = spring),
                        ProjectSkill(project = project3, skill = jpa),
                        ProjectSkill(project = project3, skill = nestjs),
                        ProjectSkill(project = project3, skill = mysql),
                        ProjectSkill(project = project3, skill = redis),
                        ProjectSkill(project = project3, skill = ncp),
                        ProjectSkill(project = project3, skill = docker)
                )
        )

        projectRepository.saveAll(mutableListOf(project1, project2, project3))

        val project4 = Project(
                name = "Nyangmunity, 고양이 이미지를 공유하고 고양이 이미지를 제공하는 서비스",
                description = "고양이 사진 공유를 좋아하는 사용자를 위해 사진 공유 커뮤니티와 여러 고양이 사진을 url 형식으로 제공하기 위해 개발",
                startYear = 2021,
                startMonth = 7,
                endYear = null,
                endMonth = null,
                isActive = true
        )
        project4.addDetails(
                mutableListOf(
                        ProjectDetail(content = "Spring Batch를 활용하여 외부 이미지 API 내 고양이 이미지를 매일 갱신하여 제공하도록 구현", url = null, isActive = true),
                        ProjectDetail(content = "S3와 Cloud Front를 활용하여 업로드한 이미지를 URL로 제공되도록 구현", url = null, isActive = true),
                        ProjectDetail(content = "Github Repository",
                                url = "https://github.com/ppusda/NyangMunity", isActive = true)
                )
        )
        project4.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project4, skill = java),
                        ProjectSkill(project = project4, skill = spring),
                        ProjectSkill(project = project4, skill = jpa),
                        ProjectSkill(project = project4, skill = vuejs),
                        ProjectSkill(project = project4, skill = mysql),
                        ProjectSkill(project = project4, skill = redis),
                        ProjectSkill(project = project4, skill = aws)
                )
        )

        projectRepository.saveAll(mutableListOf(project1, project2, project3, project4))
    }

}