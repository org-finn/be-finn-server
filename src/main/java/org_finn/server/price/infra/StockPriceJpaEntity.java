package org_finn.server.price.infra;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stock_prices",
	uniqueConstraints = {
		@UniqueConstraint(
			name = "stock_prices_stock_id_price_date_unique_key",
			columnNames = {"stock_id", "price_date"}
		)
	}
)
public class StockPriceJpaEntity {
	@Id
	@UuidGenerator
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;

	@Column(nullable = false, precision = 10, scale = 4)
	private BigDecimal openPrice;

	@Column(nullable = false, precision = 10, scale = 4)
	private BigDecimal closePrice;

	@Column(nullable = false, precision = 10, scale = 4)
	private BigDecimal adjClosePrice;

	@Column(nullable = false, precision = 10, scale = 4)
	private BigDecimal highPrice;

	@Column(nullable = false, precision = 10, scale = 4)
	private BigDecimal lowPrice;

	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal changeRate;

	@Column(columnDefinition = "bigint")
	private Long volume;

	@Column(nullable = false)
	private LocalDateTime priceDate;

	@Column(columnDefinition = "uuid", nullable = false)
	private UUID stockId;

}
