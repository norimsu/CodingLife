package kr.pe.norimsu.springrestdocs;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.epages.restdocs.apispec.ResourceSnippetParameters;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
class UserApiDocumentationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    void testRead() throws Exception {
        // given

        // when
        final ResultActions result = this.mockMvc.perform(get("/api/user/{id}", 1));

        // then
        result.andExpect(status().isOk());
        //@formatter:off
        result
                .andDo(print())
                .andDo(document("user",
                        pathParameters(
                                parameterWithName("id").description("사용자 id")),
                        responseFields(
                                fieldWithPath("resultCode").description("응답코드"),
                                fieldWithPath("data.id").description("id").type(JsonFieldType.NUMBER),
                                fieldWithPath("data.account").description("계정"),
                                fieldWithPath("data.email").description("이메일"),
                                fieldWithPath("data.phoneNumber").description("전화번호"),
                                fieldWithPath("data.createdAt").description("생성시간"),
                                fieldWithPath("data.updatedAt").description("수정시간")
                        )
                ));
        //@formatter:on
        //@formatter:off
        result
                .andDo(
                        document("user",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                resource(ResourceSnippetParameters
                                        .builder()
                                        .description("사용자의 정보를 생성/조회/수정/삭제 합니다.")
                                        .summary("사용자 정보")
                                        .pathParameters(
                                                parameterWithName("id").description("사용자 id"))
                                        .responseFields(
                                                fieldWithPath("resultCode").description("응답코드"),
                                                fieldWithPath("data.id").description("id").type(JsonFieldType.NUMBER),
                                                fieldWithPath("data.account").description("계정"),
                                                fieldWithPath("data.email").description("이메일"),
                                                fieldWithPath("data.phoneNumber").description("전화번호"),
                                                fieldWithPath("data.createdAt").description("생성시간"),
                                                fieldWithPath("data.updatedAt").description("수정시간"))
                                        .build()
                                )
                        )
                );
        //@formatter:on
    }
}
