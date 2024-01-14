package ru.nekrasov.lr6.service;

import ru.nekrasov.lr6.entity.Discipline;

import java.util.List;

public interface DisciplineService {
    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);
}