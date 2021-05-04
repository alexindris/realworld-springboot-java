package io.github.raeperd.realworld.domain.article;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArticleTest {

    @Test
    void when_update_all_possible_field_expect_return_article_updated() {
        final var article = new Article("some title", null, null);
        final var updateCommand = ArticleUpdateCommand.builder()
                .title("title-updated").description("description-updated").body("body-updated")
                .build();

        assertThat(article.updateArticle(updateCommand))
                .hasFieldOrPropertyWithValue("title", "title-updated")
                .hasFieldOrPropertyWithValue("description", "description-updated")
                .hasFieldOrPropertyWithValue("body", "body-updated");
    }

    @Test
    void when_article_has_same_id_and_title_expect_equals() {
        final var article = new Article("some title", null, null);
        final var articleWithSameTitle = new Article(article.getTitle(), null, null);

        assertThat(article)
                .isEqualTo(articleWithSameTitle)
                .hasSameHashCodeAs(articleWithSameTitle);
    }

    @Test
    void when_create_article_with_empty_space_title_expect_dash_separated_slug() {
        final var article = new Article("some title", null, null);

        assertThat(article.getSlug()).isEqualTo("some-title");
    }

}