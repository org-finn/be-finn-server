package org_finn.server.prediction.infra;

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
@Table(name = "predictions")
public class PredictionJpaEntity {
	@Id
	@UuidGenerator
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;

	@Column(nullable = false, precision = 10, scale = 4)
	private BigDecimal predictionPrice;

	@Column(precision = 5, scale = 2)
	private BigDecimal changeRate;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long capitalization = 0L;

	@Column(nullable = false)
	private LocalDateTime predictionDate;

	@Column(nullable = false, length = 20)
	private String stockCode;

	@Column(nullable = false, length = 100)
	private String companyName;
	
	@Column(columnDefinition = "uuid", nullable = false)
	private UUID stockId;
}
