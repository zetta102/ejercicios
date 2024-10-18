package com.ogc.ingreso.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `string` cumple
     * con alguna de las siguientes propiedades: 1- Todos los caracteres aparecen la
     * misma cantidad de veces. Ejemplos: "aabbcc", "abcdef", "aaaaaa" 2- Todos los
     * caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece
     * un vez mas o una vez menos. Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     *
     * @param string la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String string) {
        // Agrupamiento de caracteres por su frecuencia de aparición
        Map<String, Long> frequencyMap = Arrays.stream(string.split(""))
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        // Agrupamiento de frecuencias de aparición
        Map<Long, Long> frequencyCountMap = frequencyMap.values().stream()
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));

        // Validación de condiciones
        if (frequencyCountMap.size() == 1) {
            // Mejor caso: que todos los caracteres aparezcan la misma cantidad de veces
            return true;
        } else if (frequencyCountMap.size() == 2) {
            // El otro caso: validar que solamente uno de los caracteres aparezca una vez más, o una vez menos que el resto.
            List<Long> frequencyList = new ArrayList<>(frequencyCountMap.keySet());
            long freq1 = frequencyList.get(0);
            long freq2 = frequencyList.get(1);

            // Verificación de que la distancia entre frecuencias sea una y que el valor aparezca una sola vez
            if (Math.abs(freq1 - freq2) == 1) {
                return frequencyCountMap.get(freq1) == 1 || frequencyCountMap.get(freq2) == 1;
            }

            // Verificación de que un caracter aparezca una sola vez y los demás sean lo mismo
            return freq1 == 1 && frequencyCountMap.get(freq1) == 1 || freq2 == 1 && frequencyCountMap.get(freq2) == 1;
        }

        // Si ninguna de las condiciones es cierta, entonces es falso xd
        return false;
    }

}
