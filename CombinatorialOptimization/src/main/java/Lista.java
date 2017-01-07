/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author renansantos
 */
public class Lista {

    private Object item[];
    private int primeiro, ultimo, pos;

    public Lista(int maxTam) {
        this.item = new Object[maxTam];
        this.pos = -1;
        this.primeiro = 0;
        this.ultimo = this.primeiro;
    }

    public Object pesquisa(Object chave) {
        if (this.vazia() || chave == null) {
            return null;
        }
        for (int p = 0; p < this.ultimo; p++) {
            if (this.item[p].equals(chave)) {
                return this.item[p];
            }
        }
        return null;
    }

    public void insere(Object x) throws Exception {
        if (this.ultimo >= this.item.length) {
            throw new Exception("Erro: a lista está cheia");
        } else {
            this.item[this.ultimo] = x;
            this.ultimo++;
        }
    }

    public Object retira(Object chave) throws Exception {
        if (this.vazia() || chave == null) {//analisa consistência dos dados para pesquisa
            throw new Exception("Erro: a lista está vazia");
        }
        int p = 0;
        while (p < this.ultimo && !this.item[p].equals(chave)) {//procura a posição do item
            p++;
        }
        if (p >= this.ultimo) {//se não encontrou o item, retorna nulo
            return null;
        }

        Object item = this.item[p];//recupera o item
        this.ultimo--;

        for (int i = p; i < this.ultimo; i++) {//desloca os itens no vetor, arrumando a lista
            this.item[i] = this.item[i + 1];
        }

        return item;
    }

    public Object retiraPrimeiro() throws Exception {
        if (this.vazia()) {//analisa consistência dos dados para pesquisa
            throw new Exception("Erro: a lista está vazia");
        }
        Object item = this.item[0];
        this.ultimo--;
        for (int i = 0; i < this.ultimo; i++) {
            this.item[i] = this.item[i + 1];
        }
        return item;
    }
    
    public Object primeiro(){
        this.pos = -1;
        return this.proximo();
    }

    public Object proximo() {
        this.pos++;
        if (this.pos >= this.ultimo) {
            return null;
        } else {
            return this.item[this.pos];
        }
    }

    public boolean vazia() {
        return this.primeiro == this.ultimo;
    }
    
    public void imprime(){
        for(int i = this.primeiro; i<this.ultimo; i++){
            System.out.println(this.item[i].toString());
        }
    }
}
