package ru.uskov.dmitry.httpjenkinsnotifier.rest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JenkinsEventControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void event() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post(JenkinsEventController.PATH)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(REQUEST_BODY)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    private static final String REQUEST_BODY =
            "{\n" +
                    "   \"eventKey\":\"pr:merged\",\n" +
                    "   \"date\":\"2018-09-27T11:23:50+0300\",\n" +
                    "   \"actor\":{\n" +
                    "      \"name\":\"Ivanov-II\",\n" +
                    "      \"emailAddress\":\"Ivanov.I.I@gmail.com\",\n" +
                    "      \"id\":89271,\n" +
                    "      \"displayName\":\"Иванов Иван Иванович\",\n" +
                    "      \"active\":true,\n" +
                    "      \"slug\":\"ivanov-ii\",\n" +
                    "      \"type\":\"NORMAL\"\n" +
                    "   },\n" +
                    "   \"pullRequest\":{\n" +
                    "      \"id\":731,\n" +
                    "      \"version\":2,\n" +
                    "      \"title\":\"ISSYE-1311 исправляет NPE\",\n" +
                    "      \"state\":\"MERGED\",\n" +
                    "      \"open\":false,\n" +
                    "      \"closed\":true,\n" +
                    "      \"createdDate\":1537959355470,\n" +
                    "      \"updatedDate\":1538036629377,\n" +
                    "      \"closedDate\":1538036629377,\n" +
                    "      \"fromRef\":{\n" +
                    "         \"id\":\"refs/heads/bugfix/ISSYE-1311\",\n" +
                    "         \"displayId\":\"bugfix/ISSYE-1311\",\n" +
                    "         \"latestCommit\":\"49c201ecea8bb19b03026e9bda60a97f9dd2d90d\",\n" +
                    "         \"repository\":{\n" +
                    "            \"slug\":\"secretproject\",\n" +
                    "            \"id\":413,\n" +
                    "            \"name\":\"secretproject\",\n" +
                    "            \"scmId\":\"git\",\n" +
                    "            \"state\":\"AVAILABLE\",\n" +
                    "            \"statusMessage\":\"Available\",\n" +
                    "            \"forkable\":true,\n" +
                    "            \"project\":{\n" +
                    "               \"key\":\"INTLAB\",\n" +
                    "               \"id\":517,\n" +
                    "               \"name\":\"Секретная лаборатория\",\n" +
                    "               \"description\":\"Secret Laboratory: перспективные и экспериментальные решения\",\n" +
                    "               \"public\":false,\n" +
                    "               \"type\":\"NORMAL\"\n" +
                    "            },\n" +
                    "            \"public\":false\n" +
                    "         }\n" +
                    "      },\n" +
                    "      \"toRef\":{\n" +
                    "         \"id\":\"refs/heads/release/1.1.2_2\",\n" +
                    "         \"displayId\":\"release/1.1.2_2\",\n" +
                    "         \"latestCommit\":\"e92d119b0218737063c03afb9e92a8d70fee5cdc\",\n" +
                    "         \"repository\":{\n" +
                    "            \"slug\":\"secretproject\",\n" +
                    "            \"id\":413,\n" +
                    "            \"name\":\"Secretproject\",\n" +
                    "            \"scmId\":\"git\",\n" +
                    "            \"state\":\"AVAILABLE\",\n" +
                    "            \"statusMessage\":\"Available\",\n" +
                    "            \"forkable\":true,\n" +
                    "            \"project\":{\n" +
                    "               \"key\":\"INTLAB\",\n" +
                    "               \"id\":517,\n" +
                    "               \"name\":\"Секретная лаборатория\",\n" +
                    "               \"description\":\"Secret Laboratory: перспективные и экспериментальные решения\",\n" +
                    "               \"public\":false,\n" +
                    "               \"type\":\"NORMAL\"\n" +
                    "            },\n" +
                    "            \"public\":false\n" +
                    "         }\n" +
                    "      },\n" +
                    "      \"locked\":false,\n" +
                    "      \"author\":{\n" +
                    "         \"user\":{\n" +
                    "            \"name\":\"Ivanov-II\",\n" +
                    "            \"emailAddress\":\"Ivanov.I.I@gmail.com\",\n" +
                    "            \"id\":89271,\n" +
                    "            \"displayName\":\"Иванов Иван Иванович\",\n" +
                    "            \"active\":true,\n" +
                    "            \"slug\":\"ivanov-ii\",\n" +
                    "            \"type\":\"NORMAL\"\n" +
                    "         },\n" +
                    "         \"role\":\"AUTHOR\",\n" +
                    "         \"approved\":false,\n" +
                    "         \"status\":\"UNAPPROVED\"\n" +
                    "      },\n" +
                    "      \"reviewers\":[\n" +
                    "         {\n" +
                    "            \"user\":{\n" +
                    "               \"name\":\"Petrov-PP\",\n" +
                    "               \"emailAddress\":\"Petrov.P.P@gmail.com\",\n" +
                    "               \"id\":48940,\n" +
                    "               \"displayName\":\"Петров Пётр Петрович\",\n" +
                    "               \"active\":true,\n" +
                    "               \"slug\":\"petrov-p-p\",\n" +
                    "               \"type\":\"NORMAL\"\n" +
                    "            },\n" +
                    "            \"lastReviewedCommit\":\"49c201ecea8bb19b03026e9bda60a97f9dd2d90d\",\n" +
                    "            \"role\":\"REVIEWER\",\n" +
                    "            \"approved\":true,\n" +
                    "            \"status\":\"APPROVED\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"user\":{\n" +
                    "               \"name\":\"Sidorodov-II\",\n" +
                    "               \"emailAddress\":\"Sidorodov.I.I@gmail.com\",\n" +
                    "               \"id\":21654,\n" +
                    "               \"displayName\":\"Сидоров Иван Иванович\",\n" +
                    "               \"active\":true,\n" +
                    "               \"slug\":\"sbt-galiullin-tsh\",\n" +
                    "               \"type\":\"NORMAL\"\n" +
                    "            },\n" +
                    "            \"lastReviewedCommit\":\"49c201ecea8bb19b03026e9bda60a97f9dd2d90d\",\n" +
                    "            \"role\":\"REVIEWER\",\n" +
                    "            \"approved\":true,\n" +
                    "            \"status\":\"APPROVED\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"user\":{\n" +
                    "               \"name\":\"SonarQ\",\n" +
                    "               \"emailAddress\":\"SonarQ@gmail.com\",\n" +
                    "               \"id\":53713,\n" +
                    "               \"displayName\":\"Sonar\",\n" +
                    "               \"active\":true,\n" +
                    "               \"slug\":\"sonarq\",\n" +
                    "               \"type\":\"NORMAL\"\n" +
                    "            },\n" +
                    "            \"lastReviewedCommit\":\"49c201ecea8bb19b03026e9bda60a97f9dd2d90d\",\n" +
                    "            \"role\":\"REVIEWER\",\n" +
                    "            \"approved\":true,\n" +
                    "            \"status\":\"APPROVED\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"user\":{\n" +
                    "               \"name\":\"Vasichkin-II\",\n" +
                    "               \"emailAddress\":\"Vasichkin.I.I@gmail.com\",\n" +
                    "               \"id\":50135,\n" +
                    "               \"displayName\":\"Васичкин Иван Иванович\",\n" +
                    "               \"active\":true,\n" +
                    "               \"slug\":\"vasichlin-ii\",\n" +
                    "               \"type\":\"NORMAL\"\n" +
                    "            },\n" +
                    "            \"role\":\"REVIEWER\",\n" +
                    "            \"approved\":false,\n" +
                    "            \"status\":\"UNAPPROVED\"\n" +
                    "         }\n" +
                    "      ],\n" +
                    "      \"participants\":[\n" +
                    "\n" +
                    "      ],\n" +
                    "      \"properties\":{\n" +
                    "         \"mergeCommit\":{\n" +
                    "            \"displayId\":\"379b567405c\",\n" +
                    "            \"id\":\"379b567405c743bd7252a5d4cf978928929fd45c\"\n" +
                    "         }\n" +
                    "      }\n" +
                    "   }\n" +
                    "}";
}