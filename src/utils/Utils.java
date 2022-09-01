package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Utils {

	/**
	 * Imprime el numero y un * por cada vez que se encuentra en el array
	 * Si no esta imprime el numero sin ningun *
	 */
	public void histograma() {
		int[] myArray = new int[] {1,2,1,3,1,4,5};
		//Crea un histograma con la cantidad de veces que se repite un numero en un array
		HashMap<Integer,String> histograma= new HashMap<Integer,String>();//Se define un mapa para guardarlas ocurrencias
		//Se inicializan todos los numeros en vacio por si no esta en el array
		histograma.put(1,"");
		histograma.put(2,"");
		histograma.put(3,"");
		histograma.put(4,"");
		histograma.put(5,"");
		for(int i=0;i<myArray.length;i++){//Se recorre el array
			if(histograma.containsKey(myArray[i])) {
				//Si ya esta en el mapa, se aumenta un * en el string
				String histo=histograma.get(myArray[i])+"*";
				histograma.put(myArray[i],histo);
			}
		}
		//se imprime los numeros con su respectiva cadena
		for(Integer key:histograma.keySet())
			System. out. println(key+": "+histograma.get(key));		  
	}		

	/**
	 * Imprime el numero mayor dentro del aarray
	 */
	public void numeroMayor() {
		int[] myArray = new int[] {1,2,1,3,1,4,5};			  
		int mayor=myArray[0];
		for(int n:myArray){
			mayor = mayor>n?mayor:n;	
		}
		System.out.print(mayor);

	}	

	/**
	 * Metodo que define si un array de string es simetrica o asimetrica
	 * Simetrica: que se lee igual al derecho y al reves
	 */
	public void arrayAsimetrica() {
		String[] myArray = new String[] {"a","b","c","d","d","c","b","a"};
		String result="Asymmetric";//Define el resultado como asimetrico
		if(myArray.length%2==0) {//Verificar que el tamaño es un numero par, de lo contrario es asimetrica
			int tam = myArray.length/2;//la mitad del tamaño del array
			result="Symmetric";
			for(int i=0;i<tam;i++) {
				String cad=myArray[i];//obtener los string de inicio hasta la mitad
				String cad1=myArray[(myArray.length-1)-i];//obtener el string del final a la mitad
				if(!cad.equals(cad1)) {//Comparar si son iguales
					result="Asymmetric";//Si no son iguales se marca como asimetrica
					break;//no es necesario seguir validando
				}
			}
		}
		System. out. println(result);
	}

	public void dibujarX() {
		int n=5;
		String cadenaBase="";
		if(n>0) {
			for(int i=0;i<n;i++)
				cadenaBase+="_";//se llena la cadena _ hasta el tamaño indicado
			for(int i=0;i<n;i++){
				String cadena=cadenaBase;//en cada iteracion se inicia una nueva cadena
				//se remplaza el _ por una X en el indice hacia adelante
				cadena = cadena.substring(0,i) + 'X'+ cadena.substring(i+1);
				//se remplaza el _ por una X en el indice hacia atras
				cadena = cadena.substring(0,(n-1)-i) + 'X'+ cadena.substring(n-i);		
				System. out. println(cadena);
			}

		}
		else
			System. out. println("ERROR");
	}

	/**
	 * Dado un array que representa una matriz de nxn encuentra el camino para
	 * llegar de la columna 1 a la n que sume menos
	 */
	public void hallarCaminoMatriz() {
		int[] myArray = new int[] {1,2,1,3,1,4,5,7,6};		
		int tam=3,x=0;
		String result=myArray[0]+" ";//se obtiene la primera posicion
		for(int i=1;i<tam;i++) {
			int indice=(tam*x)+i;
			int menor=myArray[indice],xtemp=x;
			if(x-1>=0){
				indice=(tam*(x-1)+1);
				if(menor>myArray[indice]) {
					menor=myArray[indice];
					xtemp=x-1;
				}
			}
			if(x+1<3){
				indice = (tam*(x+1)+i);
				if(menor>myArray[indice]) {
					menor=myArray[indice];
					xtemp=x+1;
				}
			}
			result+=menor+" ";
			x=xtemp;
		}
		System. out. println(result.trim());
	}

	public void dibujarX1() {
		int n=6;			
		if(n>10)
			n=5;
		if(n<1)
			n=5;
		for(int i=0;i<n;i++){
			//Para establecer si empieza con X o con _
			int control = i%2==0?0:1;
			String cadena="";
			for(int j=0;j<n;j++){
				//CUando es par se coloca X
				if(control%2==0)				
					cadena+="X";
				//si es impar se coloca _
				else
					cadena=cadena+"_";
				control++;
			}
			System. out. println(cadena);
		}
	}
	

	public void elevadoCuadrado(){
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			int acumulado=a;
			for(int j=0;j<n;j++){
				acumulado+=b* Math.pow(2,j);
				System.out.printf("%d ",acumulado); 
			}
			System.out.printf("%n"); 
		}
		in.close();

	} 
	/**
	 * Busca el numero que se repita mas veces seguidas
	 */
	public void masVecesSeguidad() {
		int[] myArray = new int[] {1,2,1,3,1,4,5,7,6};		
		int numero=myArray[0],ocurrencia=1, conteo=1;
		for(int i=0;i<myArray.length-1;i++){//Se recorre el array
			if(myArray[i]==myArray[i+1])//si el numero de la posicion actual es igual al siguiente se suma uno al conteo
				conteo++;
			else //Si no se reinicia el conteo
				conteo=1;//el conteo inicia en 1, por que minimo hay una ocurrencia
			if(conteo>ocurrencia) {//si el conteo es mayor a la ocurrencia actual
				ocurrencia=conteo;//se cambia la ocurrencia
				numero=myArray[i];//se guarda el numero de la posicion
			}
		}
		//se imprime la ocurrencia y el numero
		System. out. println("Longest: "+ocurrencia);
		System. out. println("Number: "+numero);
	}

	/**
	 * Obtiene los dos primeros numeros de un array que sumen un numero dado,
	 * PLUS, se hace con un solo ciclo
	 */
	public void hallarSuma() {
		int[] myArray = new int[] {1,2,1,3,1,4,5,7,6};		
		int suma=10;
		List<Integer> diferencia=new ArrayList<Integer>(0);
		int numero1=0,numero2=0;
		for(int i=0;i<myArray.length;i++){//Se recorre el array
			int n=suma-myArray[i];//se calcula el numero que falta para llegar a la suma
			if(diferencia.contains(myArray[i])){//Si la lista de diferencias contiene el numero actual
				numero1=n;//se halla el primer numero que ya habia salido
				numero2=myArray[i];//el segundo numero es el actual
				break;//se termina el ciclo
			}
			if(!diferencia.contains(n))//si la lista de diferencias no contienen la diferencia actual se guarda
				diferencia.add(n);
		}
		//se imprime los dos numeros
		System. out. println(numero1+" "+numero2);
	}

	/**
	 * Conteo de palabras dentro de un texto con un unico ciclo
	 */
	public void contarPalabras() {
		String text="Hola que tal, tal que este problema es un tipico conteo de palabras dentro DE un texto, tener en cuenta no hacer doble ciclo";
		HashMap<String,Integer> conteo=new HashMap<String,Integer>(0);
		String[] myArray=text.split(" ");
		for(int i=0;i<myArray.length;i++){//Se recorre el array
			String pal=limpiarPalabra(myArray[i]);
			if(conteo.containsKey(pal)) {
				int cant=conteo.get(pal);
				cant++;
				conteo.put(pal,cant);
			}
			else
				conteo.put(pal,1);
		}
		//se imprime los dos numeros
		for(String key:conteo.keySet())
			System. out. println(key+": "+conteo.get(key));
	}

	public String limpiarPalabra(String pal) {
		pal=pal.replaceAll(",|;|!|¡", "");
		return pal;
	}

	/**
	 * Evalua si una cadena de parentesisi esta bien formada (abren y cierran correctamente)
	 * @param args
	 */
	public static void evaluarParentesis() {

		String evaluar="{[{[()]}]}";
		while (evaluar.contains("()")||evaluar.contains("[]")||evaluar.contains("{}")) {
			evaluar=evaluar.replace("()","").replace("[]","").replace("{}","");
		}
		System.out.println("La entrada es "+(evaluar.length()>0?"INCORRECTO":"CORRECTO"));

	}

}
