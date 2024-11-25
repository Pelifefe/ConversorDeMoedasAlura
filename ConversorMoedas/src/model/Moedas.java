package model;

import com.google.gson.annotations.SerializedName;

public record Moedas(@SerializedName("conversion_rate")double taxaDeConversao) {
}