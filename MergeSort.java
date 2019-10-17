import java.util.Random;

public class MergeSort {
	void merge(int v[], int l, int m, int r) {
		// Encontra o tamanho dos 2 vetores
		int n1 = m - l + 1;
		int n2 = r - m;

		// Vetores temporários
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copia os dados para os vetores
		for (int i = 0; i < n1; ++i)
			L[i] = v[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = v[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				v[k] = L[i];
				i++;
			} else {
				v[k] = R[j];
				j++;
			}
			k++;
		}

		// Copia o resto dos elementos em L
		while (i < n1) {
			v[k] = L[i];
			i++;
			k++;
		}

		// Copia o Resto dos elementos em R
		while (j < n2) {
			v[k] = R[j];
			j++;
			k++;
		}
	}

	void sort(int v[], int l, int r) 
	{ 
	    if (l < r) 
	    { 
	        // Encontra o meio do vetor
	        int m = (l+r)/2; 
	
	        // Organiza a primeira e segunda metade
	        sort(v, l, m); 
	        sort(v , m+1, r); 
	
	        // Junta as partes 
	        merge(v, l, m, r); 
	    } 
	}
	
	//Imprime os valores ordenados
	static void printArray(int v[]) 
    { 
        int n = v.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(v[i] + " "); 
        System.out.println(); 
    }
	
	public static void main(String[] args) {
		int n = 10;
		int v[] = new int[n];
		int i = 0;
		Random gen = new Random();

		for (i = 0; i < v.length; i++) {
			v[i] = gen.nextInt(100);
		}
		
		System.out.println("Valores Desordenados:");

		for (i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");	
		}
  
        MergeSort ob = new MergeSort(); 
        ob.sort(v, 0, v.length-1); 
  
        System.out.println("\nValores Ordenados:"); 
        printArray(v); 
	}
}
