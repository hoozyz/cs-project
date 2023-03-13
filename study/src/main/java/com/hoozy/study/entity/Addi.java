package com.hoozy.study.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "addi")
public final class Addi {
	
	@EmbeddedId // 복함 PK
	private AddiPK addi;
}
