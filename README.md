# MiniSimuladorDeRedeSocial

• JDK: ECLIPSE TEMURIN VERSION 17.0.8

• BIBLIOTECAS UTILIZADAS: 

• import javax.swing.*;

• import java.awt.*;

• import java.awt.event.ActionEvent;

• import java.awt.event.ActionListener;

• import java.util.List;

• import java.awt.Color;

• import java.awt.FlowLayout;

• import javax.swing.JButton;

• import javax.swing.JFrame;

• import javax.swing.JOptionPane;

• import javax.swing.JPanel;

• import java.util.ArrayList;

• import java.util.Objects;

Como funciona:

• Quando o programa é iniciado, aparece uma janela onde o usuário irá se cadastrar e fazer o login. Para se cadastrar, o usuário deve colocar seu nome, e-mail, senha e se a conta é do tipo usuário (usando "n" para usuário)
ou do tipo administrativa (usando "y" para administrador). Quando o usuário fazer seu cadastro, ele vai clicar em login, para poder logar.

• Depois que o usuário fazer o login, ele irá para outra janela contendo lista de amigos, adicionar amigos, remover amigo e sair da conta.

• Caso ele queira adicionar o amigo, ele deverá saber o nome desse amigo que ele deseja adicionar, quando adicionar os amigos ele deverá escrever -1 para parar de adicionar os amigos. Depois de adicionar, o amigo fica salvo na lista de amigo deste usuário.

• Caso ele deseja remover o amigo, ele terá que vê o nome do amigo na lista de amigos primeiro, para depois remover ele usando o nome, quando terminar de remover o amigo ele terá que digitar -1 para parar de remover os amigos.

• Quando o usuário for sair da conta, ele terá que clicar em sair da conta e voltará para a tela inicial de cadastro e login.

• Explicação:

JanelaAmigoForm.java

● A classe JanelaAmigoForm estende JFrame, incorporando funcionalidades de interface
gráfica e demonstrando o uso de herança para reutilizar e estender o código.
● Utiliza a interface ActionListener para tratar eventos de clique nos botões, com cada
botão implementando o método actionPerformed de forma única, exemplificando
polimorfismo.

● A implementação separada para cada ActionListener permite adicionar e modificar
comportamentos de botões de forma independente, facilitando a manutenção e
expansão do código.

● As funcionalidades específicas da aplicação, como listar, adicionar e remover amigos,
são gerenciadas por meio dos métodos actionPerformed, separando a lógica de
interface do usuário da lógica de negócios.

RedeSocialForm.java

● A classe RedeSocialForm herda de JFrame, permitindo o uso de funcionalidades para
construção de janelas, como definição de título, tamanho e layout. Essa herança facilita
a criação da interface gráfica da aplicação.

● O uso da interface ActionListener é aplicado aos botões jButtonCadastro e jButtonLogin,
com implementações específicas em seus métodos actionPerformed. Isso exemplifica
polimorfismo, onde a mesma interface resulta em comportamentos distintos
dependendo do botão acionado.

● As funcionalidades de cadastro e login são separadas da lógica da interface do usuário,
com a lógica de negócio sendo tratada dentro dos métodos actionPerformed. Isso
permite uma clara separação de responsabilidades dentro do código.

● O código utiliza um padrão de fachada através da instância de ContasFacade,
simplificando a interação entre a interface do usuário e a lógica de negócios subjacente.

● A criação e gestão de contas de usuários e administradores é feita de maneira
polimórfica, onde ambos os tipos de conta são tratados por meio de sua superclasse
Conta, mas diferenciam-se em seu comportamento e propriedades.

TipoConta .java

● Uso de Enumerações: TipoConta é definido como um enum, um tipo especial em Java
usado para definir coleções de constantes. Aqui, ele é usado para representar os tipos
de conta (USUARIO e ADMINISTRADOR) com propriedades associadas (peso e
descricao).

● Encapsulamento de Propriedades: Cada enumeração (USUARIO e ADMINISTRADOR)
tem associado a si um peso (um valor Long) e uma descricao (String). Isso mostra
encapsulamento, onde cada instância do enum contém dados específicos.

● Métodos de Acesso: Os métodos getPeso e getDescricao são métodos acessores
(getters) que permitem a obtenção dos valores das propriedades peso e descricao. Isso
é uma prática comum em Java para acessar dados de um objeto de maneira controlada.

● Construtor Privado: O construtor de TipoConta é privado (TipoConta(Long peso, String
descricao)), o que é típico para enums em Java. Isso garante que as enumerações
sejam definidas apenas dentro do próprio enum e não possam ser instanciadas
arbitrariamente em outras partes do código.

● Utilização em Polimorfismo e Decisões Lógicas: Embora não explicitado no código, é
comum que enums como TipoConta sejam usados em estruturas de decisão (como
switch ou if-else) para alterar o comportamento do programa com base no tipo da conta,
demonstrando um uso prático de polimorfismo.

Administrador.java

● Herança: Administrador é uma subclasse da classe Conta. Isso indica que
Administrador herda todas as propriedades e métodos de Conta, mas também pode ter
funcionalidades adicionais ou comportamentos modificados específicos para um
administrador.

● Sobrescrita de Método (Override): A anotação @Override acima do método getTipo
indica que este método está sobrescrevendo um método da classe pai (Conta). Esta é
uma prática comum para alterar ou estender o comportamento de um método herdado.

● Polimorfismo: O método getTipo retorna TipoConta.ADMINISTRADOR. Esta
implementação específica para a classe Administrador é um exemplo de polimorfismo,
onde diferentes subclasses de Conta podem retornar diferentes tipos de conta.

● Uso de Enums: O método getTipo faz uso do enum TipoConta, que foi analisado
anteriormente. Isso demonstra como enums podem ser integrados em classes para
representar e gerenciar tipos ou categorias de forma eficiente.

Conta.java

● Classe Abstrata: Conta é definida como uma classe abstrata, indicando que ela não
pode ser instanciada diretamente. Classes abstratas são frequentemente usadas como
base para outras classes, fornecendo uma estrutura comum para serem estendidas.

● Método Abstrato: O método getTipo, marcado como abstrato, deve ser implementado
pelas subclasses. Isso assegura que cada tipo de conta concreta (como Administrador
ou Usuario) defina seu próprio tipo de conta, conforme o enum TipoConta.

● Gestão de Relacionamentos: A classe mantém uma lista de Conta chamada amigos,
demonstrando como relações podem ser gerenciadas dentro de uma classe. Os
métodos adicionarAmigo, removerAmigo e listaDeAmigos manipulam essa lista,
permitindo adicionar, remover e listar amigos, respectivamente.

● Encapsulamento: Os atributos nome, email e senha são privados e
acessados/modificados através de métodos get e set. Isso é um exemplo de
encapsulamento, um princípio fundamental da POO para proteger o estado interno de
um objeto.

● Métodos Override de Object: Os métodos equals, hashCode e toString são sobrescritos
para fornecer funcionalidades específicas para objetos Conta. equals e hashCode são
usados para comparações e uso em coleções, enquanto toString fornece uma
representação em string do objeto.

● Uso da Biblioteca Java Objects: O método equals utiliza a classe Objects para uma
comparação segura e eficiente dos atributos, evitando NullPointerException.

Usuário.java

● Herança: A classe Usuario estende a classe abstrata Conta. Isso significa que Usuario
herda todas as propriedades e métodos de Conta, mas também pode ter
funcionalidades e comportamentos específicos para um usuário comum da rede social.

● Método Abstrato Implementado: Usuario implementa o método abstrato getTipo herdado
de Conta. Essa implementação é obrigatória para que a classe Usuario possa ser
instanciada. Ela retorna TipoConta.USUARIO, indicando que esta classe representa um
usuário comum na rede social.

● Polimorfismo: A implementação específica do método getTipo é um exemplo de
polimorfismo. Embora Conta defina a estrutura do método, cada subclasse (como
Usuario e Administrador) fornece uma implementação que reflete seu tipo específico.

● Utilização de Enums: Assim como na classe Administrador, Usuario utiliza o enum
TipoConta para fornecer uma representação concreta do tipo de conta. Isso garante
consistência e facilita o gerenciamento de diferentes tipos de contas.

ContasFacade.java

● Definição de Interface: ContasFacade é uma interface em Java, o que significa que ela
define um contrato que as classes que a implementam devem seguir. Interfaces são
fundamentais em Java para definir comportamentos padrão que podem ser
implementados de maneiras diferentes por diferentes classes.

● Métodos Declarados:

● obterContas(): Este método sugere retornar uma lista de todas as Contas. Sendo
uma operação de leitura, provavelmente não modifica o estado dos objetos.

● obterContaPorEmail(String email): Este método parece ser usado para buscar
uma Conta específica com base em um endereço de email. É um exemplo de
uma operação de busca ou consulta.

● cadastrarConta(Conta conta): Este método sugere a adição de uma nova Conta.
Representa uma operação de criação ou atualização no conjunto de dados de
contas.

● Padrão de Projeto Facade: O nome e a estrutura da interface sugerem o uso do padrão
de design Facade. O padrão Facade fornece uma interface simplificada para um
conjunto mais complexo de lógicas, como operações em um banco de dados ou
interações entre várias classes e objetos. O objetivo é desacoplar a implementação
complexa e detalhada do uso simples e direto da funcionalidade.

● Separação de Preocupações: A interface ContasFacade separa a interface (o que deve
ser feito) da implementação (como deve ser feito). Isso permite que diferentes
implementações da ContasFacade sejam criadas sem alterar o código que depende
dela, facilitando a manutenção e a expansão do sistema.

ContasFacadeImpl.java

● Implementação da Interface: ContasFacadeImpl implementa todos os métodos definidos
na interface ContasFacade. Esta é uma prática padrão em Java, onde uma classe
concreta que implementa uma interface deve fornecer implementações para todos os
métodos declarados na interface.

● Gestão de Contas:

● A classe mantém uma lista usuariosCadastrados para armazenar objetos Conta.
Esta lista é utilizada em todos os métodos implementados.

● O método obterContas retorna a lista de contas cadastradas, seguindo a
definição da interface.

● O método obterContaPorEmail percorre a lista de contas para encontrar uma
conta que corresponda ao email fornecido. Se encontrado, retorna a conta; caso
contrário, retorna null.

● O método cadastrarConta adiciona uma nova conta à lista de contas
cadastradas.

● Padrão de Projeto Facade: Conforme indicado pelo nome da classe e da interface que
ela implementa, esta classe é parte do padrão Facade. Ela oferece uma interface
simplificada para operações mais complexas relacionadas à gestão de contas, como
busca e cadastro.

● Separação de Preocupações: A implementação de ContasFacadeImpl separa a lógica
de negócios da interface do usuário e outras partes do sistema. Isso promove uma
arquitetura mais limpa e facilita a manutenção e o teste do código.

● Simplicidade e Modularidade: O uso do padrão Facade, juntamente com a
implementação de uma interface, torna o sistema mais modular e fácil de entender.
Mudanças na lógica de gerenciamento de contas podem ser feitas dentro de
ContasFacadeImpl sem afetar outras partes do sistema que usam esta funcionalidade.

