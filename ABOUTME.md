# Historias

- Caso que eu estou brigando para melhorar a experiencia do usuário em uma entrega no Order tracking
    - Situação: Entreguei uma funcionalidade de front end na empresa que estou trabalhando, para o usuário final conseguir visualizar as suas compras recentes, porém, eu utilizo um framework próprio, e tem um time especifico que cuida desse framework. Houve um problema nessa entre, pra um país especifico, o tempo de resposta do serviço é alto, e isso ocasiona em um timeout, e o usuário não tem noção disso, por que ele fica em uma tela de loading infinito.
    - Tarefa: Meu objetivo, era arrumar esse loading infinito, pois é horrivel para a experiencia do usuário ter que adivinhar que ficou preso a uma tela de loading infito
    - Ação:
        - Pesquisei algumas formas de realizar isso:
            -  Adicionar Retry (foi a que implementei)
            -  Aumentar o tempo do timeout (era ruim para experiencia do usuário, pois ele quer o conteúdo rapidamente)
            -  Diminuir latencia do serviço (já estou fazendo isso [cache], porém tenho um bloqueio arquitetural que faz com que a primeira requisição seja demorada)
    - Resultado:
        - Essa alteração do retry não foi aprovada (pois mexi em uma parte em que não era pra mexer (core do framework, outro time que cuida)), porém estou brigando para que seja.
    - Principios:
        - Obsessão pelo cliente
        - Mentalidade de dono
        - Insistir nos mais altos padrões
        - Ter iniciativa
        - Ser firme, discordar e se comprometer


- Melhora da experiencia do usuário em um sistema chamado "Portal de Eventos"
    - Situação: Quando iniciei minha carreira, no meu primeiro trabalho, fiquei responsável por cuidar de um sistema chamado Portal de Evento, nele os usuários (gestores dessa empresa que eu trabalhava) eram responsável por registrar eventos importantes que aconteciam nos Clientes da empresa (Essa empresa é especializada em cuidar da infra dos clientes)
    - Tarefa: Após realizar a entrega de uma feature importante, decidi que era momento de coletar feedbacks e realizar melhorias no sistema conforme esses feedbacks dos usuários. Na época, enviei o link de uma formulário para os usuários do Sistema (gestores), para eles informarem o que gostavam/não gostavam no sistema.
    - Ação: Após receber várias respostas, corrigi bugs e criei novas features de acordo com o que foi informado nesse formulário.
    - Resultado: Mais gestores começaram a usar o sistema (alguns tinham resistencia e preferiam registrar esses eventos em DOC) e também alguns elogios por parte da iniciativa do formulário e do funcionamento do sistema, ganhando confiança deles. Após isso, a equipe criou uma aplicação para colocar em todos os sistemas para receber feedbacks.
    - Principios:
        - Obsessão pelo cliente
        - Mentalidade de dono
        - Ter iniciativa
        - Ganhar Confiança

- Adoção de CI/CD nos sistemas da empresa que eu trabalhava
    - Situação: Em uma empresa que eu trabalhei, aconteciam muitos erros por causa de deploy errado. As vezes sistemas iam para produção apontando para banco de dados errado, as vezes iam para homologação apontando pra produção, tudo isso por que nós devs tinhamos que controlar isso. O que torna as atividade bem propensas a erro humano.
    - Tarefa: Tinha que resolver esse problema, e pensei que poderia instalar um software para realizar isso.
    - Ação: Instalei em um servidor on-premise um Jenkins, e começamos a utilizar CI/CD. Também configuramos as aplicações para não ter mais que ficar gerenciando as URL's de acesso a banco na mão.
    - Resultado: Menos erros em produção, pois agora o deploy era feito de forma automatizada. Também foi reduzido o tempo que um dev tinha que ficar cuidando da preparação de uma entrega.
    - Principios:
        - Mentalidade de dono
        - Ter iniciativa
        - Insistir nos mais altos padrões
        - Inventar e simplificar

- Adoção de SSO nos sistemas da empresa que eu trabalhava
    - Situação: Em uma empresa que eu trabalhava, existiam vários sistemas internos que utlizavam o mesmo login e senha. Vários usuários reclamavam poís tinham que ficar realizando login várias e várias vezes, pra cada sistema que fossem utilizar. Tinhamos sistemas de RH, Agendamento de sala de reunião, Agendamento de massagem, Sistemas de controle de eventos no clientes da empresa, e cada um desses fazia seu próprio login.
    - Tarefa: Pensei em uma solução pra isso, que tal uma sistema que centraliza-se o login de todos esse sistemas. Todos os sistemas faziam o login da mesma forma (verificando o AD), então talvez fosse tranquilo realizar esse modificação.
    - Ação: Estudei algumas formas de fazer isso, tanto sistemas que já são feitos com essa função, ou realizar a própria implementação. Depois de algumas discussões com meus gestores, cheguei a conclusão que a maneira mais rapida/segura de realizar isso seria utilizar um sistema já criado pra isso (Keycloak). Mobilizei o time de desenvolvedores para implementar a forma de login utilizando essa ferramenta, e integramos os sistemas com esse sistema.
    - Resultado: Usuários tiveram a experiencia melhorada no acesso entre vários sistemas, pois agora tinham de forma centralizada um login que funcionava pra todos os sistemas internos, não tendo que logar várias vezes.
    - Principios:
        - Ter iniciativa
        - Inventar e simplificar
        - Aprender e ser curioso
        - Entregar Resultado
        - Mergulhar fundo

## Perguntas:
### O que você fez ao não conseguir bater um deadline?
- BEES, página que anexamos um relatorio do powerBI
    - Situação: No sistema que trabalho atualmente, recebi a demanda de criar uma página dentro do sistema anexando um relatorio gerado em um powerBI. Realizei uma POC, e com isso estimei que conseguiria realizar essa tarefa em 1 sprint (2 semanas). Porém, o sistema que eu trabalho utiliza um framework próprio, muito baseado no React, porém com diferenças. A POC que eu tinha realizado era utilizando um Componente já utilizado pela comunidade do React, porém, não tinha compatibilidade. Na metade da Sprint, depois de pesquisar bastante, consegui dar um jeito de fazer funcionar, mas o prazo já estava ficando curto, e eu vi que não ia conseguir entregar no tempo combinado.
    - Tarefa: Sabendo disso eu vi que precisaria alinhar com meus gestores que não ia conseguir entregar a tempo essa feature.
    - Ação: Marquei algumas reuniões com meus gestores, e esclareci o porquê de não conseguir entregar a tempo essa funcionalidade.
    - Resultado: Tendo alinhado as expectativas, realizei uma nova estimativa, dessa vez mais apurada, pois já estava conseguindo desenvolver a funcionalidade. Consegui entregar a funcionalidade na metade de outra Sprint.
    - Principios:
        -  Ganhar a confiança
        -  Entregar resultados
        -  Aprender e ser curioso
        -  Inventar e simplificar

### Me conte o que fez quando já teve que tomar uma ação sem dados suficientes:
- AtendeTI: tive que decidir entre cancelar o deploy ou não de um sistema importante para o cliente
    - Situação: No inicio da minha carreira, fiquei encarregado de realizar o desenvolvimento de um sistema que funcionava como um plugin de um outro sistema. Esse outro sistema é chamado OTRS, e é um sistema de gestão de serviços, tendo funcionalidades para abrir chamado, categorizar etc. Criei um sistema para melhorar a usabilidade, para que o OTRS virasse apenas um backend, e nosso sistema fosse de apresentação.
    - Tarefa: Criamos esse sistema, e tinhamos que realizar o deploy dele, porém no dia do deploy, vários erros começaram a acontecer, e o meu gerente estava querendo cancelar o deploy.
    - Ação: Apesar de estarem acontecendos os erros, tive um presentimento que nós iriamos conseguir fazer, porém com a ajuda de mais um funcionario que era especialista na parte de rede, então pedi pro meu gestor chamar ele. Ele nos ajudou a configurar um proxy reverso e instalar o certificado que era necessário.
    - Resultado: Com isso, conseguimos realizar o deploy do sistema, os usuários conseguiram utilizar o nosso sistema em vez do OTRS, o que foi de grande valia pro cliente, uma vez que os usuários não gostavam da interface daquele sistema.
    - Principios:
        - Mentalidade de dono
        - Obsessão pelo cliente
        - Ter iniciativa
        - Ser firme, discordar e se comprometer
        - Entregar resultados



### Dê-me um exemplo de quando você assumiu uma postura impopular em uma reunião com seus colegas e seu líder e você foi a exceção. O que foi, por que você se sentiu forte sobre isso e o que você fez?

No meu primeiro emprego na area de desenvolvimento, eu tinha um gerente que abominava o uso de algumas ferramentas que ajudavam na construção de código, como frameworks. (Spring por exemplo)
De vez em quando, tinhamos reuniãos chamadas tech talks, e eu costumava apresentar algumas ferramentas, porém, meu gerente e colegas não viam tanta importancia, e geralmente eu discordava deles, pois o trabalho utilizando essas ferramentas iria melhorar.

Para provar isso, criei uma prova de conceito e mostrei aos colegas, mostrando como era mais rapido de criar aquilo, e como iria ficar mais fácil nosso fluxo de trabalho, onde nós poderiamos focar mais nas regras do negocio.

Me senti forte em relação a isso pois eu sentia que podia ajudar o ambiente a não ter tantas dores de cabeça como eu mesmo estava passando.



### Conte-me sobre um momento em que você buscou perspectivas diferentes das suas para melhorar um produto/serviço/projeto?

No meu trabalho atual, fiquei encarregado de realizar um desenvolvimento de um filtro que una um checkbox com um campo de texto que filtrava esses checkboxes.
O comportamento dessa estrutura, da forma que foi passada, era estranho, se eu fosse o cliente, não iria gostar tanto, e eu tinha um sentimento que nós podiamos melhora-lo.

Verificando outras plataformas, notei que existia um padrão. Ao clicar no checkbox, essa opção iria para o topo, e a página era recarregada, limpando o campo de texto. Também surgia um botão para realizar a limpeza dos checkboxes.

Informei o responsavel pelo produto por essa forma de realizar o filtro, resultando na modificação do fluxo para que esse filtro fique mais intuitivo.

Também tagueamos esse campo para coletar dados de como o usuário está utilizando essa ferramenta. 







