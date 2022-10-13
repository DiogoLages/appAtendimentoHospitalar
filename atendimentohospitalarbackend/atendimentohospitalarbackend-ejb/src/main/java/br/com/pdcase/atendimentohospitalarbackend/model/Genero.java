package br.com.pdcase.atendimentohospitalarbackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Genero implements EnumType {
	M("Masculino"), 
	F("Feminino");

	private String descricao;

	private Genero(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	@JsonValue
	public String getType() {
		return this.toString();
	}

	@JsonCreator
	public static Genero fromObject(JsonNode node) {
		String type = null;
		if (node.getNodeType().equals(JsonNodeType.STRING)) {
			type = node.asText();
		} else {
			if (!node.has("type")) {
				throw new IllegalArgumentException();
			}
			type = node.get("type").asText();
		}
		return valueOf(type);
	}
}
