package controller;

import fateczl.listaEncadeada.model.ListaEncadeada;

public class Controller03 {

	ListaEncadeada lista = new ListaEncadeada();

	public void popularLista(int[] vetor) throws Exception {

		for (int i = 0; i < vetor.length; i++) {
			if (lista.isEmpty()) {
				lista.addFirst(vetor[i]);
			} else
				lista.add(vetor[i], i);
		}

	}

	public void doisMaiores() throws Exception {
		int maior = 0;
		int segundoMaior = 0;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) > maior) {
				segundoMaior = maior;
				maior = lista.get(i);
			} else if (lista.get(i) > segundoMaior && lista.get(i) < maior) {
				segundoMaior = lista.get(i);
			}
		}
		System.out.println("Maiores numeros: " + segundoMaior + " e " + maior);
	}
}
