package gerenciamentoHospitalFINAL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "saida.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = carregarPacientes();

        while (true) {
            System.out.println("\n1. Incluir Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Consultar Paciente");
            System.out.println("5. Listar Pacientes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> incluirPaciente(scanner, pacientes);
                case 2 -> alterarPaciente(scanner, pacientes);
                case 3 -> excluirPaciente(scanner, pacientes);
                case 4 -> consultarPaciente(scanner, pacientes);
                case 5 -> listarPacientes(pacientes);
                case 6 -> {
                    salvarPacientes(pacientes);
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static List<Paciente> carregarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                pacientes.add(Paciente.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Nenhum arquivo encontrado, iniciando um novo.");
        }
        return pacientes;
    }

    private static void salvarPacientes(List<Paciente> pacientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Paciente paciente : pacientes) {
                bw.write(paciente.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private static void incluirPaciente(Scanner scanner, List<Paciente> pacientes) {
        System.out.print("Número: ");
        int numero = scanner.nextInt();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();

        pacientes.add(new Paciente(numero, peso, altura));
        System.out.println("Paciente incluído com sucesso!");
    }

    private static void alterarPaciente(Scanner scanner, List<Paciente> pacientes) {
        System.out.print("Número do paciente a alterar: ");
        int numero = scanner.nextInt();

        for (Paciente paciente : pacientes) {
            if (paciente.getNumero() == numero) {
                System.out.print("Novo peso: ");
                paciente.setPeso(scanner.nextDouble());
                System.out.print("Nova altura: ");
                paciente.setAltura(scanner.nextDouble());
                System.out.println("Paciente alterado com sucesso!");
                return;
            }
        }
        System.out.println("Paciente não encontrado!");
    }

    private static void excluirPaciente(Scanner scanner, List<Paciente> pacientes) {
        System.out.print("Número do paciente a excluir: ");
        int numero = scanner.nextInt();

        pacientes.removeIf(paciente -> paciente.getNumero() == numero);
        System.out.println("Paciente excluído com sucesso!");
    }

    private static void consultarPaciente(Scanner scanner, List<Paciente> pacientes) {
        System.out.print("Número do paciente a consultar: ");
        int numero = scanner.nextInt();

        for (Paciente paciente : pacientes) {
            if (paciente.getNumero() == numero) {
                paciente.listarPaciente();
                return;
            }
        }
        System.out.println("Paciente não encontrado!");
    }

    private static void listarPacientes(List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        for (Paciente paciente : pacientes) {
            paciente.listarPaciente();
        }
    }
}
