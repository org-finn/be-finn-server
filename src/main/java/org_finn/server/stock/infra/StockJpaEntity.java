package org_finn.server.stock.infra;

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
@Table(name = "stocks")
public class StockJpaEntity {

	@Id
	@UuidGenerator
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;

	@Column(unique = true, nullable = false, length = 20)
	private String stockCode;

	@Column(nullable = false, length = 100)
	private String companyName;

	@Column(nullable = false, length = 100)
	private String country;

	@Column(length = 50)
	private String category;

	@Column(length = 100)
	private String searchKeyword;

	@Column(nullable = false)
	private LocalDateTime createdAt;
}
