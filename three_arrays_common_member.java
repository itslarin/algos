Даны три неубывающих массива чисел. Найти число, которое присутствует во всех трех массивах.

Input: [1,2,4,5], [3,3,4], [2,3,4,5,6]

[1,2,4,5], [3, 5], [2,3,4,5,6]

Output: 4
Целевое решение работает за O(p + q + r), где p, q, r – длины массивов, доп. память O(1), но эту информацию интервьюер не сообщает.



public int myMethod2(int[]arr1, int[] arr2, int[] arr3) { //optimised solution with O(max(p,q,r)) calc complexity and O(1) memory complexity
		int i, j, k = 0;
    int max = -1;
    
    while (i < arr1.length && j < arr2.lenth && k < arr3.length) {      
      
      if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        return arr1[i];
      }
      
      max = Math.max(arr1[i], Math.max(arr2[j], arr3[k]));
			
      while (i < arr1.length && arr1[i] < max) {
      	i++;
      }
      while (j < arr2.lenth  && arr2[j] < max) {
      	j++;
      }
      while (k < arr3.length && arr3[k] < max) {
      	k++;
      }
      
    }
    
		return -1;    
}



public int myMethod2(int[]arr1, int[] arr2, int[] arr3) { //straight solution with O(p*q*r) calc complexity and O(1) memory complexity
	int i, j, k = 0;
  
  for (i = 0; i < arr1.length; i++) {

    for (j = 0; j < arr2.length; j++) {
			if (arr1[i] != arr2[j]) {
      	continue;
      }
      for (k = 0; k < arr3.length; k++) {
				if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        	return arr1[i];
        }
      }

    }

  }
  
  return -1;
}