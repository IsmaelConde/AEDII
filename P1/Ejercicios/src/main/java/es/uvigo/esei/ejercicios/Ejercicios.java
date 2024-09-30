/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.uvigo.esei.ejercicios;

/**
 *
 * @author Ismael
 */
public class Ejercicios {

    public static void main(String[] args) {
        System.out.println("4! = " + ejercicio1(4));
        System.out.println("4^2= " + ejercicio2(4));
        System.out.println("La suma de 1573 = " + ejercicio3(1573));
        System.out.println("mcd de 18 y 35 = " + ejercicio4(18, 35));
        System.out.println("\"Cosa\" al revés = " + ejercicio5("Cosa"));
        System.out.println("La suma de [1,2,3] es = " + ejercicio6(new int[]{1,2,3}));
        System.out.print("El array [1,2,3] pasa a: "); imprimirEjercicio7(new int[]{1,2,3});
        System.out.println("El pequeño de [4,7,1,3] es = " + ejercicio8(new int[]{4,7,1,3}));
    }
    
    public static int ejercicio1(int num){
        if(num == 1){
            return 1;
        }
        return ejercicio1(num - 1)*num;
    }
    
    public static int ejercicio2(int num){
        if(num <= 0){
            return 0;
        }
        return ejercicio2(num-1) + (2*num)-1;
    }
    
    public static int ejercicio3(int num){
        if(num < 10){
            return num;
        }
        return (num % 10) + ejercicio3(num/10);
    }
    
    public static int ejercicio4(int num1, int num2){
        if(num1 == num2){
            return num1;
        }
        if(num1 == 0){
            return num2;
        }
        if(num2 == 0){
            return num1;
        }
        if(num1 > num2){
            return ejercicio4(num2,num1-num2);
        }
        return ejercicio4(num1, num2-num1);
    }
    
    public static String ejercicio5(String p){
        return ejercicio5(p,p.length()-1);
    }
    
    public static String ejercicio5(String p, int pos){
        if(pos == 0){
            return p.charAt(0) + "";
        }
        
        return p.charAt(pos) + ejercicio5(p,pos-1);
    }
    
    public static int ejercicio6(int[] nums){
        return ejercicio6(nums, nums.length-1);
    }
    
    public static int ejercicio6(int[] nums, int pos){
        if(pos == 0){
            return nums[0];
        }
        
        return nums[pos] + ejercicio6(nums, pos-1);
    }
    
    public static void ejercicio7(int[] nums, int inicio, int fin){
        if(inicio<fin){
            int aux = nums[inicio];
            nums[inicio] = nums[fin];
            nums[fin] = aux;
            ejercicio7(nums, inicio+1, fin-1);
        }
    }
    
    public static void imprimirEjercicio7(int[] nums){
        ejercicio7(nums, 0, nums.length-1);
        String mostrar = "[";
        for (int i = 0; i < nums.length; i++) {
            mostrar += nums[i];
            if(i == nums.length - 1){
                mostrar += "]";
            }else{
                mostrar += ",";
            }
        }
        System.out.println(mostrar);
    }
    
    public static int ejercicio8(int[] nums){
        return ejercicio8(nums, 10, 0);
    }
    
    public static int ejercicio8(int[] nums, int menor, int pos){
        if(pos == nums.length){
            return menor;
        }
        if(nums[pos] < menor){
            menor = nums[pos];
        }
        return ejercicio8(nums, menor, pos+1);
    }
    
    
}
