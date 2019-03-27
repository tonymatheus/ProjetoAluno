package com.br.projetoaluno.vicente.eda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

	public class ListaDados <E> implements List<E>
	{
		private Object[] objetos;
		private int tamanho;
		
		public ListaDados()
		{
			objetos = new Object[10];
			tamanho = 0;
		}
		
		public ListaDados(int initialCapacity)
		{
			objetos = new Object[initialCapacity];
			tamanho = 0;
		}
		
		@Override
		public boolean add(E objeto)
		{
			gerarEspaço();
			if(tamanho < objetos.length)
			{
				objetos[tamanho] = objeto;
				tamanho++;
				return true;
			}
			return false;
		}
		
		private void gerarEspaço()
		{
			if (tamanho == objetos.length)
			{
				Object[] novoArray = new Object[tamanho*2];
				for(int c = 0; c < objetos.length; c++)
					novoArray[c] = objetos[c];
				objetos = novoArray;
			}
				
		}

		@Override
		public void add(int pos, E objeto)
		{
			if(pos == tamanho)
				add(objeto);
			if(!(pos >= 0 && pos < tamanho))
				throw new IllegalArgumentException("Posição inválida!!!");
			for(int i = tamanho-1; i >= pos; i--)
			{
				objetos[i+1] = objetos[i]; 
			}
			objetos[pos] = objeto;
			tamanho++;
		}

		@Override
		public boolean addAll(Collection<? extends E> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int arg0, Collection<? extends E> arg1) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(Object arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E get(int pos)
		{
			if(!(pos >= 0 && pos < tamanho))
				throw new IllegalArgumentException("Posição inválida!!!");
			return (E) objetos[pos];	
		}

		@Override
		public int indexOf(Object objeto)
		{
			for (int i = 0; i < tamanho; i++)
			{
				if (objeto.equals(objetos[i]))
					return i;
			}
			return -1;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int lastIndexOf(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<E> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<E> listIterator(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean remove(Object objeto)
		{
			int pos = indexOf(objeto);
			if(pos > -1)
			{
				remove(pos);
				return true;
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E remove(int pos)
		{
			if(!(pos >= 0 && pos < tamanho))
				throw new IllegalArgumentException("Posição inválida!!!");
			
			Object aux = objetos[pos];
			for(int i = pos; i < tamanho-1; i++)
				objetos[i] = objetos[i+1];
			tamanho--;
			
			return (E) aux;
		}

		@Override
		public boolean removeAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E set(int pos, E objeto)
		{
			if(!(pos >= 0 && pos < tamanho))
				throw new IllegalArgumentException("Posição inválida!!!");
			objetos[pos] = objeto;
			return (E) objetos[pos];
		}

		@Override
		public int size()
		{
			return tamanho;
		}

		@Override
		public List<E> subList(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String toString()
		{
			StringBuilder s = new StringBuilder();
			for(int i = 0; i < tamanho; i++)
			{
				s.append(objetos[i]);
				s.append("\n");
			}
			return s.toString();
		}
		
	}

