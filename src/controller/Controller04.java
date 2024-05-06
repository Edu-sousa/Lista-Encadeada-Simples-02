package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import fateczl.listaSetGenerica.model.ListaSetGenerica;
import model.Cliente;

public class Controller04 {

	public void novoArquivo(String caminho, ListaSetGenerica lista, String nomeArquivo) throws Exception {

		File dir = new File(caminho);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(caminho, nomeArquivo);
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}

			StringBuffer buffer = new StringBuffer();
			int tamanho = lista.size();
			String linha = "";
			for (int i = 0; i < tamanho; i++) {
				linha = lista.get(i).toString();
				buffer.append(linha + "\n"); // concatena texto em um objeto StringBuffer em Java + quebra de linha
			}

			FileWriter fileWriter = new FileWriter(arq, existe); // abre o arquivo e define a operação, write ou append
			PrintWriter print = new PrintWriter(fileWriter); // escreve o conteudo no fileWriter
			print.write(buffer.toString());
			print.flush(); // finaliza a escrita
			print.close();
			fileWriter.close(); // fecha o arquivo
		} else {
			throw new IOException("Diretório inválido");
		}

	}

	public void novoCadastro(String caminho, String arquivo, int idadeMin, int idadeMax, Double limiteCredito)
			throws Exception {
		// instanciando a lista Object de clientes
		ListaSetGenerica listaCliente = new ListaSetGenerica();

		File file = new File(caminho, arquivo);

		if (file.exists() && file.isFile()) {
			FileInputStream fluxo = new FileInputStream(file); // abrir arquivo
			InputStreamReader leitor = new InputStreamReader(fluxo); // ler arquivo
			BufferedReader buffer = new BufferedReader(leitor); // colocar conteudo no buffer

			String linha = buffer.readLine(); // ler linha

			while (linha != null) {
//				System.out.println(linha);

				String[] infoClientes = linha.split(";");

				// mudando o formato da String para ser convertida em um Double
				infoClientes[3] = infoClientes[3].replace(",", ".");
				Cliente cliente = new Cliente(infoClientes[0], infoClientes[1], Integer.parseInt(infoClientes[2]),
						Double.parseDouble(infoClientes[3])); // CPF, Nome, Idade, Salario

				// verificando as condições propostas
				if (Integer.parseInt(infoClientes[2]) >= idadeMin && Integer.parseInt(infoClientes[2]) <= idadeMax
						&& Double.parseDouble(infoClientes[3]) > limiteCredito) {
					if (listaCliente.isEmpty()) {
						listaCliente.addFirst(cliente);
					} else
						listaCliente.addLast(cliente);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}

//		String nomeArquivo = "Idades entre " + idadeMin +" e "+idadeMax+ "  e Credito de " + limiteCredito + ".txt";
		String nomeArquivo = "Idades entre " + idadeMin + " e " + idadeMax + "  e Credito de " + limiteCredito + ".csv";
		novoArquivo(caminho, listaCliente, nomeArquivo);

	}

}
