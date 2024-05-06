package view;

import controller.Controller03;

public class View03 {

	public static void main(String[] args) throws Exception {
		int[] vetor = { 3, 5, 8, 12, 9, 7, 6, 2, 3, 7, 16 };

		Controller03 cont = new Controller03();

		cont.popularLista(vetor);
		cont.doisMaiores();
	}
}
