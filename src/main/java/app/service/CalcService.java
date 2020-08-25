package app.service;

import app.repo.CalcRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CalcService {


    private final CalcRepo calcRepo;


    public CalcService(CalcRepo calcRepo) {
        this.calcRepo = calcRepo;
    }

    public Double calc(String op){
       try {
           final boolean edgeChecker = Character.isDigit(op.charAt(0)) && Character.isDigit(op.charAt(op.length() - 1));
           if ((op.contains("*"))&& edgeChecker){
               final String[] numbers = op.split("\\*", 2);
               return Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
           }else if ((op.contains("+"))&& edgeChecker){
               final String[] numbers = op.split("\\+", 2);
               return Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
           }else if ((op.contains("-"))&& edgeChecker){
               final String[] numbers = op.split("\\-", 2);
               return Double.parseDouble(numbers[0])-Double.parseDouble(numbers[1]);
           }else   if ((op.contains("\\/"))&& edgeChecker){
               final String[] numbers = op.split("\\/", 2);
               if (Double.parseDouble(numbers[1])!=0){
                   return Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
               }
           }
       }catch (Exception ex){

       }
        return 0D;
    }
}
