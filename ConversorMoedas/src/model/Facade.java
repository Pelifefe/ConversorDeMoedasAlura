package model;

import com.google.gson.Gson;
import http.Response;

import java.io.IOException;

public class Facade {

    public void operacoes(int opc, double valor) throws IOException, InterruptedException {
        double taxa;
        switch (opc) {
            case 1 -> {
                taxa = taxaConversao("USD", "ARS");
                resposta("USD", "ARS", valor, taxa);
            }
            case 2 -> {
                taxa = taxaConversao("ARS", "USD");
                resposta("ARS", "USD", valor, taxa);
            }
            case 3 -> {
                taxa = taxaConversao("USD", "BRL");
                resposta("USD", "BRL", valor, taxa);
            }
            case 4 -> {
                taxa = taxaConversao("BRL", "USD");
                resposta("BRL", "USD", valor, taxa);
            }
            case 5 -> {
                taxa = taxaConversao("USD", "COP");
                resposta("USD", "COP", valor, taxa);
            }
            case 6 -> {
                taxa = taxaConversao("COP", "USD");
                resposta("COP", "USD", valor, taxa);
            }
            default -> throw new IllegalArgumentException("Opção inválida: " + opc);
        }
    }

    private double taxaConversao(String moedaBase, String moedaAlvo) throws IOException, InterruptedException {
        Response response = new Response(moedaBase, moedaAlvo);
        String json = response.getResponse();
        Gson gson = new Gson();
        Moedas moedas = gson.fromJson(json, Moedas.class);
        return moedas.taxaDeConversao();
    }

    private void resposta(String moedaBase, String moedaAlvo, double valor, double taxa) {
        double valorConvertido = valor * taxa;
        String resposta = "Valor " + valor + " [" + moedaBase + "] corresponde ao valor final de -> " + valorConvertido + " [" + moedaAlvo + "]";
        System.out.println(resposta);
    }
}