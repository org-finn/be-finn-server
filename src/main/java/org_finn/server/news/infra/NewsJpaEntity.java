package org_finn.server.news.infra;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "news")
public class NewsJpaEntity {

	@Id
	@UuidGenerator
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(columnDefinition = "text")
	private String originalUrl;

	@Column(columnDefinition = "text")
	private String thumbnailUrl;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long viewCount = 0L;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long likeCount = 0L;

	@Column(precision = 8, scale = 6)
	private BigDecimal sentimentScore;

	@Column(nullable = false)
	private LocalDateTime createdDate;

	@Column(nullable = false, length = 100)
	private String companyName;

	@Column(columnDefinition = "uuid", nullable = false)
	private UUID stockId;
}
