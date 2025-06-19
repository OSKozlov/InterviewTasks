package com.interview.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implement collections logic as described.
 */
public class Task08Collections {

    static class Student {
        private String name;
        private List<String> languages;

        Student(String name, List<String> languages) {
            this.name = name;
            this.languages = languages;
        }

        public String getName() {
            return name;
        }

        public List<String> getLanguages() {
            return languages;
        }


    }

    // Data example
    static final List<Student> students = Arrays.asList(
            new Student("Doug Lea", Arrays.asList("Java", "C#", "JavaScript")),
            new Student("Bjarne Stroustrup", Arrays.asList("C", "C++", "Java")),
            new Student("Bjarne Stroustrup", Arrays.asList("C", "C++", "Java")),
            new Student("Martin Odersky", Arrays.asList("Java", "Scala", "Smalltalk"))
    );

    /**
     * Given list of students group them by language.
     */
    public static Map<String, List<Student>> getStudentsByLanguage(List<Student> students) {
        if (students == null) return Collections.EMPTY_MAP;
        return students.stream().flatMap(student ->
            student.getLanguages().stream().map(lang -> new AbstractMap.SimpleEntry<>(lang, student) {})
        ).collect(Collectors.groupingBy(Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }

    /**
     * Given list of students with languages, return list of unique languages.
     */
    public static List<String> getAllLanguages(List<Student> students) {
        if (students == null) return Collections.EMPTY_LIST;
        Set<String> languages = new HashSet<>();
        for(Student student : students) {
            languages.addAll(student.getLanguages());
        }
        return new ArrayList<>(languages);
    }

    /**
     * Given list of students, remove duplicates by name.
     */
    public static List<Student> removeDuplicates(List<Student> students) {
        if (students == null) return Collections.emptyList();
        Map<String, Student> map = new HashMap<>();
        students.forEach(entry -> map.putIfAbsent(entry.getName(), entry));
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        Map<String, List<Student>> studByLang = getStudentsByLanguage(students);
        List<String> languages = getAllLanguages(students);
        List<Student> unique = removeDuplicates(students);
        System.out.println();
    }

}