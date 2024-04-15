import analysis.GeneCounter;
import analysis.GeneticCombinations;
import information.DateManager;
import information.DocumentOrganizer;
import information.TextSearcher;
import numeric.MaxFinder;
import numeric.NumberListing;
import numeric.NumberSummation;
import numeric.PowerCalculator;
import optimization.QuicksortOptimizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Menú Principal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            GeneCounter geneCounter = new GeneCounter();
            GeneticCombinations geneticCombinations = new GeneticCombinations();
            DateManager dateManager = new DateManager();
            DocumentOrganizer documentOrganizer = new DocumentOrganizer();
            TextSearcher textSearcher = new TextSearcher();
            MaxFinder maxFinder = new MaxFinder();
            NumberListing numberListing = new NumberListing();
            NumberSummation numberSummation = new NumberSummation();
            PowerCalculator powerCalculator = new PowerCalculator();
            QuicksortOptimizer quicksortOptimizer = new QuicksortOptimizer();

            JButton button1 = new JButton("Contar genes");
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String genes = JOptionPane.showInputDialog(null, "Introduce una secuencia de genes (por ejemplo, ATGATGATG):");
                    if (genes != null) {
                        int geneCount = geneCounter.countGenes(genes);
                        JOptionPane.showMessageDialog(null, "Número de genes: " + geneCount);
                    }
                }
            });

            JButton button2 = new JButton("Calcular combinaciones genéticas");
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String geneLengthStr = JOptionPane.showInputDialog(null, "Introduce la longitud del gen:");
                    if (geneLengthStr != null) {
                        int geneLength = Integer.parseInt(geneLengthStr);
                        int combinations = geneticCombinations.calculateCombinations(geneLength);
                        JOptionPane.showMessageDialog(null, "Número de combinaciones: " + combinations);
                    }
                }
            });

            JButton button3 = new JButton("Agregar fechas");
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String continueAddingDates;
                    do {
                        String dateStr = JOptionPane.showInputDialog(null, "Introduce una fecha en formato YYYY-MM-DD:");
                        if (dateStr != null) {
                            LocalDate date = LocalDate.parse(dateStr);
                            dateManager.addDate(date);
                            JOptionPane.showMessageDialog(null, "Fecha añadida. Fechas: " + dateManager.getDates());
                        }
                        continueAddingDates = JOptionPane.showInputDialog(null, "¿Deseas agregar otra fecha? (si/no):");
                    } while ("si".equalsIgnoreCase(continueAddingDates));
                }
            });

            JButton button4 = new JButton("Organizar documento");
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String filePath = JOptionPane.showInputDialog(null, "Introduce la ruta del archivo para organizar:");
                    if (filePath != null) {
                        try {
                            documentOrganizer.organizeDocument(filePath);
                            JOptionPane.showMessageDialog(null, "Documento organizado correctamente.");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error al organizar el documento.");
                        }
                    }
                }
            });

            JButton button5 = new JButton("Buscar en documento");
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String filePathForSearch = JOptionPane.showInputDialog(null, "Introduce la ruta del archivo para buscar:");
                    String searchTerm = JOptionPane.showInputDialog(null, "Introduce la palabra a buscar:");
                    if (filePathForSearch != null && searchTerm != null) {
                        try {
                            List<Integer> lineNumbers = textSearcher.searchInFile(filePathForSearch, searchTerm);
                            JOptionPane.showMessageDialog(null, "La palabra se encontró en las líneas: " + lineNumbers);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error al buscar en el documento.");
                        }
                    }
                }
            });

            JButton button6 = new JButton("Encontrar número máximo");
            button6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String numbersStr = JOptionPane.showInputDialog(null, "Introduce una serie de números separados por espacios:");
                    if (numbersStr != null) {
                        String[] numbersArr = numbersStr.split(" ");
                        int[] numbers = new int[numbersArr.length];
                        for (int i = 0; i < numbersArr.length; i++) {
                            numbers[i] = Integer.parseInt(numbersArr[i]);
                        }
                        int max = maxFinder.findMax(numbers);
                        JOptionPane.showMessageDialog(null, "Número máximo: " + max);
                    }
                }
            });

            JButton button7 = new JButton("Listar números");
            button7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String startEndStr = JOptionPane.showInputDialog(null, "Introduce el número inicial y final para listar los números, separados por un espacio:");
                    if (startEndStr != null) {
                        try {
                            String[] startEndArr = startEndStr.split(" ");
                            int start = Integer.parseInt(startEndArr[0]);
                            int end = Integer.parseInt(startEndArr[1]);
                            String numbers = numberListing.listNumbers(start, end);
                            JOptionPane.showMessageDialog(null, "Números listados: " + numbers);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, introduce dos números separados por un espacio.");
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, introduce dos números separados por un espacio.");
                        }
                    }
                }
            });

            JButton button8 = new JButton("Sumar números");
            button8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nStr = JOptionPane.showInputDialog(null, "Introduce un número para calcular su suma:");
                    if (nStr != null) {
                        int n = Integer.parseInt(nStr);
                        int sum = numberSummation.sumNumbers(n);
                        JOptionPane.showMessageDialog(null, "Suma de números: " + sum);
                    }
                }
            });

            JButton button9 = new JButton("Calcular potencia");
            button9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String baseExponentStr = JOptionPane.showInputDialog(null, "Introduce la base y el exponente para calcular la potencia, separados por un espacio:");
                    if (baseExponentStr != null) {
                        String[] baseExponentArr = baseExponentStr.split(" ");
                        double base = Double.parseDouble(baseExponentArr[0]);
                        int exponent = Integer.parseInt(baseExponentArr[1]);
                        double power = powerCalculator.calculatePower(base, exponent);
                        JOptionPane.showMessageDialog(null, "Cálculo de potencia: " + power);
                    }
                }
            });

            JButton button10 = new JButton("Ordenar números");
            button10.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String arrayStr = JOptionPane.showInputDialog(null, "Introduce una serie de números separados por espacios para ordenarlos:");
                    if (arrayStr != null) {
                        String[] arrayArr = arrayStr.split(" ");
                        int[] array = new int[arrayArr.length];
                        for (int i = 0; i < arrayArr.length; i++) {
                            array[i] = Integer.parseInt(arrayArr[i]);
                        }
                        quicksortOptimizer.quickSort(array, 0, array.length - 1);
                        StringBuilder sortedArrayStr = new StringBuilder("Array ordenado: ");
                        for (int i : array) {
                            sortedArrayStr.append(i).append(" ");
                        }
                        JOptionPane.showMessageDialog(null, sortedArrayStr.toString());
                    }
                }
            });

            JButton button11 = new JButton("Búsqueda Eficiente en Textos");
            button11.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String filePathForSearch = JOptionPane.showInputDialog(null, "Introduce la ruta del archivo para buscar:");
                    String searchTerm = JOptionPane.showInputDialog(null, "Introduce la palabra a buscar:");
                    String searchType = JOptionPane.showInputDialog(null, "Introduce el tipo de búsqueda (lineal o binaria):");
                    if (filePathForSearch != null && searchTerm != null && searchType != null) {
                        try {
                            List<Integer> lineNumbers;
                            if ("lineal".equalsIgnoreCase(searchType)) {
                                lineNumbers = textSearcher.searchInFile(filePathForSearch, searchTerm);
                            } else if ("binaria".equalsIgnoreCase(searchType)) {
                                lineNumbers = textSearcher.binarySearchInFile(filePathForSearch, searchTerm);
                            } else {
                                JOptionPane.showMessageDialog(null, "Tipo de búsqueda no reconocido. Por favor, introduce 'lineal' o 'binaria'.");
                                return;
                            }
                            JOptionPane.showMessageDialog(null, "La palabra se encontró en las líneas: " + lineNumbers);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error al buscar en el documento.");
                        }
                    }
                }
            });

            panel.add(button1);
            panel.add(button2);
            panel.add(button3);
            panel.add(button4);
            panel.add(button5);
            panel.add(button6);
            panel.add(button7);
            panel.add(button8);
            panel.add(button9);
            panel.add(button10);
            panel.add(button11);

            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}