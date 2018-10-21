package edu.uddp.util;


import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UuidCodeUtil {


    public  static List<String> setCodes(){
        //int[] sums = {0,1,2,3,4,5,6,7,8,9};
        List<String> codeList = new ArrayList<>();
        for (int i1 = 0; i1 <10 ; i1++) {
            for (int i2 = 0; i2 <10 ; i2++) {
                if(i2==i1){
                    continue;
                }
                for (int i3 =0; i3 <10 ; i3++) {
                    if(i3==i2||i3==i1){
                        continue;
                    }
                    for (int i4 = 0; i4 <10 ; i4++) {
                        if(i4==i3||i4==i2||i4==i1){
                            continue;
                        }
                        for (int i5 = 0; i5 <10 ; i5++) {
                        if(i5==i4||i5==i3||i5==i2||i5==i1){
                            continue;
                        }
                            System.out.println(String.valueOf(i1)+String.valueOf(i2)+String.valueOf(i3)+String.valueOf(i4)+String.valueOf(i5));
                            String uuidCode =String.valueOf(i1)+String.valueOf(i2)+String.valueOf(i3)+String.valueOf(i4)+String.valueOf(i5);
                            codeList.add(uuidCode);
                        }
                    }
                }
            }
        }
        return codeList;
    }
}
