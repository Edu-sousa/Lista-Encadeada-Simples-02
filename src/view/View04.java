package view;

import controller.Controller04;

public class View04 {

	public static void main(String[] args) throws Exception {

		Controller04 cont = new Controller04();

		String caminho = "C:\\Users\\user\\OneDrive - Fatec Centro Paula Souza\\Desktop\\Temp";
		String arquivo = "cadastro.txt";
		cont.novoCadastro(caminho, arquivo, 41, 60, 8000.00);
		cont.novoCadastro(caminho, arquivo, 31, 40, 5000.00);
		cont.novoCadastro(caminho, arquivo, 21, 30, 3000.00);

	}
}
