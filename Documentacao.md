Documentação do Projeto: Sistema de Magias

Sumário:

Descrição do Projeto
Objetivos
Estrutura de Classes
Requisitos de Execução
Guia de Uso
Tratamento de Exceções
Expansões Futuras

Descrição do Projeto:
Este projeto foi desenvolvido como parte do estudo de Programação Orientada a Objetos (POO) em Java, com foco em herança, polimorfismo e tratamento de exceções. A ideia principal é criar um sistema de gerenciamento de magias em um jogo, onde diferentes tipos de magias podem ser criadas, aplicadas e gerenciadas por uma classe principal chamada GestorDeMagias.

Funcionalidades:
Criação e armazenamento de diferentes tipos de magias (por exemplo, magias de fogo e água).
Utilização de herança e polimorfismo para manipular diferentes tipos de magia.
Aplicação das magias com efeitos específicos de acordo com seu tipo.
Tratamento de exceções quando magias não são encontradas ou ocorrem erros na aplicação das magias.
Objetivos
Objetivo Geral
Implementar um sistema de magias em Java usando conceitos de POO, como herança, polimorfismo e tratamento de exceções.

Objetivos Específicos:
Criar classes abstratas e concretas para modelar diferentes tipos de magias.
Gerenciar as magias criadas em um sistema que permita adicionar, listar e aplicar magias.
Tratar exceções de forma personalizada, fornecendo mensagens claras sobre erros.

Estrutura de Classes
1. Classe Magia (Abstract)

public abstract class Magia {
    protected String nome;
    protected int poder;

    public Magia(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }

    public abstract void aplicar();

    public String descrever() {
        return "Magia: " + nome + ", Poder: " + poder;
    }
}

Descrição: A classe Magia é abstrata, e serve como base para outras magias específicas (como MagiaFogo e MagiaAgua). Define o nome e poder da magia, e declara o método abstrato aplicar(), que deve ser implementado nas subclasses.

2. Classe MagiaFogo (Concrete)

public class MagiaFogo extends Magia {
    private int intensidade;

    public MagiaFogo(String nome, int poder, int intensidade) {
        super(nome, poder);
        this.intensidade = intensidade;
    }

    @Override
    public void aplicar() {
        System.out.println("Aplicando magia de fogo com intensidade: " + intensidade);
    }
}

Descrição: Implementa uma magia de fogo, com uma propriedade adicional intensidade, que afeta o efeito da magia.

3. Classe MagiaAgua (Concrete)

public class MagiaAgua extends Magia {
    private int profundidade;

    public MagiaAgua(String nome, int poder, int profundidade) {
        super(nome, poder);
        this.profundidade = profundidade;
    }

    @Override
    public void aplicar() {
        System.out.println("Aplicando magia de água com profundidade: " + profundidade);
    }
}

Descrição: Implementa uma magia de água, com a propriedade profundidade, que afeta seu efeito.

4. Classe GestorDeMagias

import java.util.ArrayList;
import java.util.List;

public class GestorDeMagias {
    private List<Magia> magias = new ArrayList<>();

    public void adicionarMagia(Magia magia) {
        magias.add(magia);
    }

    public void usarMagia(String nome) throws MagiaNaoEncontradaException {
        for (Magia magia : magias) {
            if (magia.descrever().contains(nome)) {
                magia.aplicar();
                return;
            }
        }
        throw new MagiaNaoEncontradaException("Magia não encontrada: " + nome);
    }

    public void listarMagias() {
        for (Magia magia : magias) {
            System.out.println(magia.descrever());
        }
    }
}

Descrição: Gerencia a adição, listagem e uso de magias. Utiliza polimorfismo para aplicar diferentes tipos de magia através de uma interface comum.

5. Classe MagiaNaoEncontradaException

public class MagiaNaoEncontradaException extends Exception {
    public MagiaNaoEncontradaException(String message) {
        super(message);
    }
}

Descrição: Trata a exceção personalizada quando uma magia solicitada não é encontrada.

Requisitos de Execução
Pré-requisitos
Java JDK instalado (versão 8 ou superior).
Um editor de código ou IDE (como IntelliJ, Eclipse ou VSCode).
Compilação e Execução
Compilar o código: No terminal, dentro do diretório do projeto, execute:


javac *.java
Executar o programa: Após a compilação, execute o programa principal:

java Main
Guia de Uso
Exemplo de uso do Sistema de Magias
Adicionar Magias: O GestorDeMagias é responsável por adicionar diferentes tipos de magia (fogo e água, por exemplo).

GestorDeMagias gestor = new GestorDeMagias();
gestor.adicionarMagia(new MagiaFogo("Explosão Flamejante", 50, 10));
gestor.adicionarMagia(new MagiaAgua("Onda Tsunami", 40, 15));
Listar Magias: Para listar as magias cadastradas:

gestor.listarMagias();
Usar Magia: Para usar uma magia específica pelo nome:

gestor.usarMagia("Explosão Flamejante");
Tratamento de Exceções: Caso uma magia que não existe seja solicitada:

try {
    gestor.usarMagia("Tornado");
} catch (MagiaNaoEncontradaException e) {
    System.out.println(e.getMessage());
}

Tratamento de Exceções
Exceção Personalizada: MagiaNaoEncontradaException
Descrição: Essa exceção é lançada quando uma magia solicitada não é encontrada no sistema.
Exemplo:
java

try {
    gestor.usarMagia("MagiaInexistente");
} catch (MagiaNaoEncontradaException e) {
    System.out.println(e.getMessage());  // Output: Magia não encontrada: MagiaInexistente
}

Expansões Futuras
Adicionar Novos Tipos de Magias: Podemos expandir o sistema para incluir outros tipos de magias como vento, terra, eletricidade, etc.

Implementação de Efeitos Visuais: Integrar o sistema de magias com gráficos ou efeitos visuais para simular a aplicação das magias.

Persistência de Dados: Utilizar um banco de dados para armazenar magias persistentes entre execuções.