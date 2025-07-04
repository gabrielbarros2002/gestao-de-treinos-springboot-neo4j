package com.barros.gestao_de_treinos.config;

import com.barros.gestao_de_treinos.entities.*;
import com.barros.gestao_de_treinos.entities.enums.Perfil;
import com.barros.gestao_de_treinos.mappers.AvaliacaoFisicaMapper;
import com.barros.gestao_de_treinos.repositories.ExercicioRepository;
import com.barros.gestao_de_treinos.repositories.GrupoMuscularRepository;
import com.barros.gestao_de_treinos.repositories.TreinoRepository;
import com.barros.gestao_de_treinos.repositories.UsuarioRepository;
import com.barros.gestao_de_treinos.services.AvaliacaoFisicaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
@Profile({"test", "dev"})
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GrupoMuscularRepository grupoMuscularRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private AvaliacaoFisicaService avaliacaoFisicaService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() > 0) return;

        // 1. Inserir alunos
        Usuario aluno1 = new Usuario(null, "João Silva", "joao.silva@email.com", "senha1234", LocalDate.of(1995, 5, 15), Perfil.ALUNO);
        Usuario aluno2 = new Usuario(null, "Maria Oliveira", "maria.oliveira@email.com", "mariA123", LocalDate.of(1998, 8, 22), Perfil.ALUNO);
        Usuario aluno3 = new Usuario(null, "Carlos Souza", "carlos.souza@email.com", "carlos456", LocalDate.of(2000, 1, 10), Perfil.ALUNO);
        Usuario aluno4 = new Usuario(null, "Ana Pereira", "ana.pereira@email.com", "ana7890", LocalDate.of(1999, 11, 30), Perfil.ALUNO);
        Usuario aluno5 = new Usuario(null, "Pedro Costa", "pedro.costa@email.com", "pedroC0st4", LocalDate.of(1997, 3, 25), Perfil.ALUNO);
        Usuario aluno6 = new Usuario(null, "Juliana Santos", "juliana.santos@email.com", "juli@n4", LocalDate.of(1996, 7, 18), Perfil.ALUNO);
        Usuario aluno7 = new Usuario(null, "Lucas Fernandes", "lucas.fernandes@email.com", "lukasF3rn", LocalDate.of(2001, 2, 14), Perfil.ALUNO);

        usuarioRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4, aluno5, aluno6, aluno7));

        // 2. Inserir instrutoes
        Usuario instrutorMarcos = new Usuario(null, "Marcos Profissional", "marcos.prof@academia.com", "Instrutor1", LocalDate.of(1985, 9, 12), Perfil.INSTRUTOR);
        Usuario instrutorPatricia = new Usuario(null, "Patrícia Campeã", "patricia.campea@academia.com", "P@tricia2024", LocalDate.of(1988, 4, 5), Perfil.INSTRUTOR);
        Usuario instrutorRicardo = new Usuario(null, "Ricardo Forte", "ricardo.forte@academia.com", "Muscul@cao", LocalDate.of(1990, 12, 20), Perfil.INSTRUTOR);

        usuarioRepository.saveAll(Arrays.asList(instrutorMarcos, instrutorPatricia, instrutorRicardo));

        // 1. Criar grupos musculares individualmente
        GrupoMuscular grupoPeito = new GrupoMuscular(null, "Peito");
        GrupoMuscular grupoCostas = new GrupoMuscular(null, "Costas");
        GrupoMuscular grupoPernas = new GrupoMuscular(null, "Pernas");
        GrupoMuscular grupoOmbros = new GrupoMuscular(null, "Ombros");
        GrupoMuscular grupoBiceps = new GrupoMuscular(null, "Bíceps");
        GrupoMuscular grupoTriceps = new GrupoMuscular(null, "Tríceps");
        GrupoMuscular grupoGluteos = new GrupoMuscular(null, "Glúteos");
        GrupoMuscular grupoPanturrilhas = new GrupoMuscular(null, "Panturrilhas");
        GrupoMuscular grupoAbdomen = new GrupoMuscular(null, "Abdômen");
        GrupoMuscular grupoAntebracos = new GrupoMuscular(null, "Antebraços");

        // 2. Salvar os grupos musculares
        grupoMuscularRepository.saveAll(Arrays.asList(grupoPeito, grupoCostas, grupoPernas, grupoOmbros, grupoBiceps, grupoTriceps,
                grupoGluteos, grupoPanturrilhas, grupoAbdomen, grupoAntebracos));

        // 3. Criar e salvar os exercícios com os mesmos nomes dos exercícios
        Exercicio supinoReto = new Exercicio(null, "Supino reto", "Exercício clássico para trabalhar o peitoral maior", grupoPeito);
        Exercicio crucifixoReto = new Exercicio(null, "Crucifixo reto", "Isolamento para o peitoral", grupoPeito);
        Exercicio supinoInclinadoComHalteres = new Exercicio(null, "Supino inclinado com halteres", "Trabalha a parte superior do peitoral", grupoPeito);
        Exercicio puxadaFrente = new Exercicio(null, "Puxada frente", "Trabalha o latíssimo do dorso", grupoCostas);
        Exercicio remadaCurvada = new Exercicio(null, "Remada curvada", "Exercício composto para costas", grupoCostas);
        Exercicio barraFixa = new Exercicio(null, "Barra fixa", "Exercício completo para desenvolvimento das costas", grupoCostas);
        Exercicio agachamentoLivre = new Exercicio(null, "Agachamento livre", "Trabalha quadríceps, glúteos e posteriores", grupoPernas);
        Exercicio cadeiraFlexora = new Exercicio(null, "Cadeira flexora", "Foca nos posteriores de coxa", grupoPernas);
        Exercicio legPress45 = new Exercicio(null, "Leg press 45°", "Exercício completo para membros inferiores", grupoPernas);
        Exercicio desenvolvimentoComHalteres = new Exercicio(null, "Desenvolvimento com halteres", "Fortalece os deltoides", grupoOmbros);
        Exercicio elevacaoLateral = new Exercicio(null, "Elevação lateral", "Isola a cabeça média do deltoide", grupoOmbros);
        Exercicio remadaAlta = new Exercicio(null, "Remada alta", "Trabalha os deltoides e trapézios", grupoOmbros);
        Exercicio roscaDireta = new Exercicio(null, "Rosca direta", "Isola o bíceps braquial", grupoBiceps);
        Exercicio roscaMartelo = new Exercicio(null, "Rosca martelo", "Trabalha o braquiorradial e o bíceps", grupoBiceps);
        Exercicio roscaConcentrada = new Exercicio(null, "Rosca concentrada", "Exercício de isolamento máximo para bíceps", grupoBiceps);
        Exercicio tricepsTesta = new Exercicio(null, "Tríceps testa", "Exercício para a cabeça longa do tríceps", grupoTriceps);
        Exercicio tricepsCorda = new Exercicio(null, "Tríceps corda", "Foco na cabeça lateral do tríceps", grupoTriceps);
        Exercicio mergulhoEntreBancos = new Exercicio(null, "Mergulho entre bancos", "Exercício com peso corporal para tríceps", grupoTriceps);
        Exercicio elevacaoPelvica = new Exercicio(null, "Elevação pélvica", "Trabalha os glúteos e posteriores", grupoGluteos);
        Exercicio gluteoNaPolia = new Exercicio(null, "Glúteo na polia", "Isolamento para glúteos", grupoGluteos);
        Exercicio afundoComPasso = new Exercicio(null, "Afundo com passo", "Exercício dinâmico para glúteos", grupoGluteos);
        Exercicio elevacaoPanturrilhasEmPe = new Exercicio(null, "Elevação de panturrilhas em pé", "Foco nos gastrocnêmios", grupoPanturrilhas);
        Exercicio panturrilhaNoLegPress = new Exercicio(null, "Panturrilha no leg press", "Variação para panturrilhas", grupoPanturrilhas);
        Exercicio panturrilhaSentado = new Exercicio(null, "Panturrilha sentado", "Trabalha o sóleo (porção profunda)", grupoPanturrilhas);
        Exercicio abdominalInfra = new Exercicio(null, "Abdominal infra", "Trabalha a parte inferior do abdômen", grupoAbdomen);
        Exercicio pranchaAbdominal = new Exercicio(null, "Prancha abdominal", "Trabalha toda a região do core", grupoAbdomen);
        Exercicio russianTwist = new Exercicio(null, "Russian twist", "Exercício para oblíquos e core", grupoAbdomen);
        Exercicio roscaPunho = new Exercicio(null, "Rosca punho", "Fortalece os músculos do antebraço", grupoAntebracos);
        Exercicio extensaoDePunho = new Exercicio(null, "Extensão de punho", "Isola os extensores do antebraço", grupoAntebracos);
        Exercicio apertaoDePegada = new Exercicio(null, "Apertão de pegada", "Exercício para fortalecimento geral do antebraço", grupoAntebracos);

        exercicioRepository.saveAll(Arrays.asList(supinoReto, crucifixoReto, supinoInclinadoComHalteres, puxadaFrente, remadaCurvada, barraFixa,
                agachamentoLivre, cadeiraFlexora, legPress45, desenvolvimentoComHalteres, elevacaoLateral, remadaAlta,
                roscaDireta, roscaMartelo, roscaConcentrada, tricepsTesta, tricepsCorda, mergulhoEntreBancos,
                elevacaoPelvica, gluteoNaPolia, afundoComPasso, elevacaoPanturrilhasEmPe, panturrilhaNoLegPress,
                panturrilhaSentado, abdominalInfra, pranchaAbdominal, russianTwist, roscaPunho, extensaoDePunho,
                apertaoDePegada));


        // 1. Criar treinos com instrutores já instanciados
        Treino treinoAvancadoA = new Treino(null, "Treino Avançado A - Peito/Tríceps", instrutorMarcos);
        List<TreinoExercicio> exerciciosTreinoAvancadoA = List.of(
                // Treino 1: Peito/Tríceps
                new TreinoExercicio(null, supinoReto, 4, 8, 1),
                new TreinoExercicio(null, roscaDireta, 3, 10, 2),
                new TreinoExercicio(null, crucifixoReto, 3, 12, 3),
                new TreinoExercicio(null, remadaCurvada, 4, 10, 4),
                new TreinoExercicio(null, tricepsTesta, 3, 12, 5),
                new TreinoExercicio(null, abdominalInfra, 3, 15, 6)
        );
        treinoAvancadoA.setExercicios(exerciciosTreinoAvancadoA);

        Treino treinoAvancadoB = new Treino(null, "Treino Avançado B - Costas/Bíceps", instrutorPatricia);
        List<TreinoExercicio> exerciciosTreinoAvancadoB = List.of(
                // Treino 2: Costas/Bíceps
                new TreinoExercicio(null, puxadaFrente, 4, 8, 1),
                new TreinoExercicio(null, roscaPunho, 3, 6, 2),
                new TreinoExercicio(null, remadaCurvada, 4, 10, 3),
                new TreinoExercicio(null, roscaConcentrada, 3, 10, 4),
                new TreinoExercicio(null, roscaMartelo, 3, 12, 5),
                new TreinoExercicio(null, panturrilhaSentado, 2, 15, 6)
        );
        treinoAvancadoB.setExercicios(exerciciosTreinoAvancadoB);

        Treino treinoAvancadoC = new Treino(null, "Treino Avançado C - Pernas/Ombros", instrutorRicardo);
        List<TreinoExercicio> exerciciosTreinoAvancadoC = List.of(
                // Treino 3: Pernas/Ombros
                new TreinoExercicio(null, agachamentoLivre, 5, 6, 1),
                new TreinoExercicio(null, remadaAlta, 4, 8, 2),
                new TreinoExercicio(null, cadeiraFlexora, 4, 10, 3),
                new TreinoExercicio(null, elevacaoLateral, 4, 8, 4),
                new TreinoExercicio(null, elevacaoPelvica, 3, 12, 5),
                new TreinoExercicio(null, gluteoNaPolia, 3, 15, 6)
        );
        treinoAvancadoC.setExercicios(exerciciosTreinoAvancadoC);

        Treino treinoFullBodyIntensivo = new Treino(null, "Treino Full Body Intensivo", instrutorMarcos);
        List<TreinoExercicio> exerciciosTreinoFullBodyIntensivo = List.of(
                // Treino 4: Full Body Intensivo
                new TreinoExercicio(null, supinoReto, 4, 8, 1),
                new TreinoExercicio(null, crucifixoReto, 4, 8, 2),
                new TreinoExercicio(null, agachamentoLivre, 4, 8, 3),
                new TreinoExercicio(null, cadeiraFlexora, 3, 10, 4),
                new TreinoExercicio(null, tricepsCorda, 3, 10, 5),
                new TreinoExercicio(null, abdominalInfra, 3, 45, 6)
        );
        treinoFullBodyIntensivo.setExercicios(exerciciosTreinoFullBodyIntensivo);

        Treino treinoForcaSuperior = new Treino(null, "Treino Força - Superior", instrutorPatricia);
        List<TreinoExercicio> exerciciosTreinoForcaSuperior = List.of(
                // Treino 5: Força - Superior
                new TreinoExercicio(null, supinoReto, 5, 5, 1),
                new TreinoExercicio(null, crucifixoReto, 5, 5, 2),
                new TreinoExercicio(null, elevacaoLateral, 4, 6, 3),
                new TreinoExercicio(null, remadaCurvada, 4, 6, 4),
                new TreinoExercicio(null, tricepsTesta, 3, 8, 5)
        );
        treinoForcaSuperior.setExercicios(exerciciosTreinoForcaSuperior);

        Treino treinoHipertrofiaInferior = new Treino(null, "Treino Hipertrofia - Inferior", instrutorRicardo);
        List<TreinoExercicio> exerciciosTreinoHipertrofiaInferior = List.of(
                // Treino 6: Hipertrofia - Inferior
                new TreinoExercicio(null, agachamentoLivre, 5, 8, 1),
                new TreinoExercicio(null, cadeiraFlexora, 4, 10, 2),
                new TreinoExercicio(null, legPress45, 4, 12, 3),
                new TreinoExercicio(null, tricepsCorda, 3, 12, 4),
                new TreinoExercicio(null, afundoComPasso, 4, 15, 5),
                new TreinoExercicio(null, elevacaoPanturrilhasEmPe, 3, 20, 6)
        );
        treinoHipertrofiaInferior.setExercicios(exerciciosTreinoHipertrofiaInferior);

        Treino treinoFuncionalCompleto = new Treino(null, "Treino Funcional Completo", instrutorMarcos);
        List<TreinoExercicio> exerciciosTreinoFuncionalCompleto = List.of(
                // Treino 7: Funcional Completo
                new TreinoExercicio(null, agachamentoLivre, 4, 12, 1),
                new TreinoExercicio(null, tricepsCorda, 3, 12, 2),
                new TreinoExercicio(null, abdominalInfra, 3, 60, 3),
                new TreinoExercicio(null, roscaPunho, 3, 20, 4),
                new TreinoExercicio(null, roscaConcentrada, 3, 15, 5)
        );
        treinoFuncionalCompleto.setExercicios(exerciciosTreinoFuncionalCompleto);

        Treino treinoResistenciaMuscular = new Treino(null, "Treino Resistência Muscular", instrutorPatricia);
        List<TreinoExercicio> exerciciosTreinoResistenciaMuscular = List.of(
                // Treino 8: Resistência Muscular
                new TreinoExercicio(null, puxadaFrente, 4, 15, 1),
                new TreinoExercicio(null, supinoReto, 4, 15, 2),
                new TreinoExercicio(null, agachamentoLivre, 3, 20, 3),
                new TreinoExercicio(null, tricepsTesta, 3, 20, 4),
                new TreinoExercicio(null, abdominalInfra, 3, 60, 5)
        );
        treinoResistenciaMuscular.setExercicios(exerciciosTreinoResistenciaMuscular);

        Treino treinoDefinicaoABC = new Treino(null, "Treino Definição - ABC", instrutorRicardo);
        List<TreinoExercicio> exerciciosTreinoDefinicaoABC = List.of(
                // Treino 9: Definição - ABC
                new TreinoExercicio(null, supinoReto, 4, 12, 1),
                new TreinoExercicio(null, crucifixoReto, 4, 12, 2),
                new TreinoExercicio(null, agachamentoLivre, 4, 15, 3),
                new TreinoExercicio(null, tricepsTesta, 3, 15, 4),
                new TreinoExercicio(null, abdominalInfra, 3, 15, 5),
                new TreinoExercicio(null, abdominalInfra, 3, 60, 6)
        );
        treinoDefinicaoABC.setExercicios(exerciciosTreinoDefinicaoABC);

        Treino treinoPreparatorioFisico = new Treino(null, "Treino Preparatório Físico", instrutorMarcos);
        List<TreinoExercicio> exerciciosTreinoPreparatorioFisico = List.of(
                // Treino 10: Preparatório Físico
                new TreinoExercicio(null, supinoReto, 3, 12, 1),
                new TreinoExercicio(null, crucifixoReto, 3, 12, 2),
                new TreinoExercicio(null, agachamentoLivre, 3, 15, 3),
                new TreinoExercicio(null, cadeiraFlexora, 3, 12, 4),
                new TreinoExercicio(null, abdominalInfra, 3, 45, 5),
                new TreinoExercicio(null, roscaPunho, 3, 10, 6)
        );
        treinoPreparatorioFisico.setExercicios(exerciciosTreinoPreparatorioFisico);

        // 2. Salvar os treinos no banco de dados
        treinoRepository.saveAll(Arrays.asList(treinoAvancadoA, treinoAvancadoB, treinoAvancadoC,
                treinoFullBodyIntensivo, treinoForcaSuperior, treinoHipertrofiaInferior, treinoFuncionalCompleto,
                treinoResistenciaMuscular, treinoDefinicaoABC, treinoPreparatorioFisico));

        // Aluno 1 (João Silva) - 3 treinos
        Set<String> idsTreinosAluno1 = Set.of(treinoAvancadoA.getId(), treinoAvancadoB.getId(), treinoAvancadoC.getId());
        System.out.println("Atribuindo treinos " + idsTreinosAluno1 + " para o aluno " + aluno1.getId());
        usuarioRepository.atribuirTreinosAoAluno(aluno1.getId(), idsTreinosAluno1);

        // Aluno 2 (Maria Oliveira) - 4 treinos
        Set<String> idsTreinosAluno2 = Set.of(treinoAvancadoB.getId(), treinoFullBodyIntensivo.getId(),
                treinoForcaSuperior.getId(), treinoPreparatorioFisico.getId());
        usuarioRepository.atribuirTreinosAoAluno(aluno2.getId(), idsTreinosAluno2);

        // Aluno 3 (Carlos Souza) - 5 treinos
        Set<String> idsTreinosAluno3 = Set.of(treinoAvancadoA.getId(), treinoAvancadoC.getId(),
                treinoFullBodyIntensivo.getId(), treinoForcaSuperior.getId(), treinoResistenciaMuscular.getId());
        usuarioRepository.atribuirTreinosAoAluno(aluno3.getId(), idsTreinosAluno3);

        // Aluno 4 (Ana Pereira) - 3 treinos
        Set<String> idsTreinosAluno4 = Set.of(treinoAvancadoB.getId(), treinoHipertrofiaInferior.getId(),
                treinoPreparatorioFisico.getId());
        usuarioRepository.atribuirTreinosAoAluno(aluno4.getId(), idsTreinosAluno4);

        // Aluno 5 (Pedro Costa) - 4 treinos
        Set<String> idsTreinosAluno5 = Set.of(treinoAvancadoC.getId(), treinoAvancadoA.getId(),
                treinoHipertrofiaInferior.getId(), treinoResistenciaMuscular.getId());
        usuarioRepository.atribuirTreinosAoAluno(aluno5.getId(), idsTreinosAluno5);

        // Aluno 6 (Juliana Santos) - 3 treinos
        Set<String> idsTreinosAluno6 = Set.of(treinoAvancadoA.getId(), treinoForcaSuperior.getId(),
                treinoPreparatorioFisico.getId());
        usuarioRepository.atribuirTreinosAoAluno(aluno6.getId(), idsTreinosAluno6);

        // Aluno 7 (Lucas Fernandes) - 5 treinos
        Set<String> idsTreinosAluno7 = Set.of(treinoAvancadoB.getId(), treinoFullBodyIntensivo.getId(),
                treinoHipertrofiaInferior.getId(), treinoResistenciaMuscular.getId(), treinoPreparatorioFisico.getId());
        usuarioRepository.atribuirTreinosAoAluno(aluno7.getId(), idsTreinosAluno7);

        // Instanciando as avaliações físicas
        List<AvaliacaoFisica> avaliacoesFisicas = List.of(
                // Aluno 1 (João Silva)
                new AvaliacaoFisica(null, LocalDate.of(2024, 1, 15), BigDecimal.valueOf(78.50), BigDecimal.valueOf(1.75), BigDecimal.valueOf(18.50), BigDecimal.valueOf(62.30), instrutorMarcos, aluno1),
                new AvaliacaoFisica(null, LocalDate.of(2024, 4, 15), BigDecimal.valueOf(76.20), BigDecimal.valueOf(1.75), BigDecimal.valueOf(16.80), BigDecimal.valueOf(63.10), instrutorPatricia, aluno1),
                new AvaliacaoFisica(null, LocalDate.of(2024, 7, 15), BigDecimal.valueOf(74.80), BigDecimal.valueOf(1.75), BigDecimal.valueOf(15.20), BigDecimal.valueOf(63.50), instrutorRicardo, aluno1),

                // Aluno 2 (Maria Oliveira)
                new AvaliacaoFisica(null, LocalDate.of(2024, 1, 10), BigDecimal.valueOf(65.30), BigDecimal.valueOf(1.68), BigDecimal.valueOf(22.30), BigDecimal.valueOf(49.80), instrutorMarcos, aluno2),
                new AvaliacaoFisica(null, LocalDate.of(2024, 4, 10), BigDecimal.valueOf(63.50), BigDecimal.valueOf(1.68), BigDecimal.valueOf(20.50), BigDecimal.valueOf(50.20), instrutorPatricia, aluno2),
                new AvaliacaoFisica(null, LocalDate.of(2024, 7, 10), BigDecimal.valueOf(61.80), BigDecimal.valueOf(1.68), BigDecimal.valueOf(19.20), BigDecimal.valueOf(50.50), instrutorRicardo, aluno2),

                // Aluno 3 (Carlos Souza)
                new AvaliacaoFisica(null, LocalDate.of(2024, 2, 5), BigDecimal.valueOf(82.40), BigDecimal.valueOf(1.80), BigDecimal.valueOf(20.10), BigDecimal.valueOf(64.70), instrutorMarcos, aluno3),
                new AvaliacaoFisica(null, LocalDate.of(2024, 5, 5), BigDecimal.valueOf(84.60), BigDecimal.valueOf(1.80), BigDecimal.valueOf(19.50), BigDecimal.valueOf(67.20), instrutorPatricia, aluno3),
                new AvaliacaoFisica(null, LocalDate.of(2024, 8, 5), BigDecimal.valueOf(86.20), BigDecimal.valueOf(1.80), BigDecimal.valueOf(18.80), BigDecimal.valueOf(69.10), instrutorRicardo, aluno3),

                // Aluno 4 (Ana Pereira)
                new AvaliacaoFisica(null, LocalDate.of(2024, 2, 20), BigDecimal.valueOf(58.70), BigDecimal.valueOf(1.65), BigDecimal.valueOf(24.60), BigDecimal.valueOf(43.20), instrutorMarcos, aluno4),
                new AvaliacaoFisica(null, LocalDate.of(2024, 5, 20), BigDecimal.valueOf(56.90), BigDecimal.valueOf(1.65), BigDecimal.valueOf(23.10), BigDecimal.valueOf(43.60), instrutorPatricia, aluno4),
                new AvaliacaoFisica(null, LocalDate.of(2024, 8, 20), BigDecimal.valueOf(55.30), BigDecimal.valueOf(1.65), BigDecimal.valueOf(21.80), BigDecimal.valueOf(44.00), instrutorRicardo, aluno4),

                // Aluno 5 (Pedro Costa)
                new AvaliacaoFisica(null, LocalDate.of(2024, 3, 1), BigDecimal.valueOf(90.20), BigDecimal.valueOf(1.82), BigDecimal.valueOf(25.30), BigDecimal.valueOf(66.50), instrutorMarcos, aluno5),
                new AvaliacaoFisica(null, LocalDate.of(2024, 6, 1), BigDecimal.valueOf(88.50), BigDecimal.valueOf(1.82), BigDecimal.valueOf(23.80), BigDecimal.valueOf(67.80), instrutorPatricia, aluno5),
                new AvaliacaoFisica(null, LocalDate.of(2024, 9, 1), BigDecimal.valueOf(86.70), BigDecimal.valueOf(1.82), BigDecimal.valueOf(22.50), BigDecimal.valueOf(68.40), instrutorRicardo, aluno5),

                // Aluno 6 (Juliana Santos)
                new AvaliacaoFisica(null, LocalDate.of(2024, 3, 12), BigDecimal.valueOf(62.40), BigDecimal.valueOf(1.70), BigDecimal.valueOf(26.40), BigDecimal.valueOf(44.90), instrutorMarcos, aluno6),
                new AvaliacaoFisica(null, LocalDate.of(2024, 6, 12), BigDecimal.valueOf(60.80), BigDecimal.valueOf(1.70), BigDecimal.valueOf(24.90), BigDecimal.valueOf(45.30), instrutorPatricia, aluno6),
                new AvaliacaoFisica(null, LocalDate.of(2024, 9, 12), BigDecimal.valueOf(59.50), BigDecimal.valueOf(1.70), BigDecimal.valueOf(23.60), BigDecimal.valueOf(45.80), instrutorRicardo, aluno6),

                // Aluno 7 (Lucas Fernandes)
                new AvaliacaoFisica(null, LocalDate.of(2024, 1, 22), BigDecimal.valueOf(70.30), BigDecimal.valueOf(1.78), BigDecimal.valueOf(17.80), BigDecimal.valueOf(57.20), instrutorMarcos, aluno7),
                new AvaliacaoFisica(null, LocalDate.of(2024, 4, 22), BigDecimal.valueOf(72.60), BigDecimal.valueOf(1.78), BigDecimal.valueOf(16.50), BigDecimal.valueOf(59.80), instrutorPatricia, aluno7),
                new AvaliacaoFisica(null, LocalDate.of(2024, 7, 22), BigDecimal.valueOf(74.20), BigDecimal.valueOf(1.78), BigDecimal.valueOf(15.20), BigDecimal.valueOf(61.50), instrutorRicardo, aluno7)
        );

        avaliacoesFisicas.forEach(avaliacaoFisica ->
                avaliacaoFisicaService.insert(AvaliacaoFisicaMapper.toDTO(avaliacaoFisica)));

        System.out.println("Dados iniciais carregados com sucesso!");
    }
}
