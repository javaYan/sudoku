package yyy.sudoku;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SudokuApplication {
    public static void main(String[] args) {
        SpringApplication.run(SudokuApplication.class, args);
        log.info("------------SudokuApplication start up successfully------------");
    }

}