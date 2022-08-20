package org.example.design;

import java.util.HashMap;

public class LRUCache {


    // LRU cache é um tipo de cache que descarta o menos usado recentemente quando a capacidade for esgotada
    // Por exemplo, eu tenho um cache de capacidade 2, coloco dois valores
    //  (1, 1) , (2, 2)
    // Como o 2 foi colocado após o 1, o 1 fica como menos recente (comportamento de lista duplamente encadeada? aparentemente)
    // Ficando assim (2, 2), (1, 1)
    // Ao colocar buscar um valor, por exemplo o (1,1), agora que ele foi usado, o valor vem pro topo da fila
    // ficando [(1,1), (2, 2)]
    // Ao colocar um novo elemento, por exemplo (3,3), eu vou verificar a fila, tirar o que foi utilizado menos recentemente
    // que no nosso caso, tá no fim, e colocar o (3,3) como mais novo
    // ficando assim [(3,3), (1,1)]
    // Se é um cache, eu tenho que ter velocidade pra inserir, buscar e deletar um item


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        System.out.println(cache.get(1));
        cache.put(1, 2);
        System.out.println(cache.get(1));
        cache.put(2, 3);
        cache.put(3, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    final int capacity;
    int size = 0;
    HashMap<Integer, Node> keyValueMap = new HashMap<>();
    private final Node head;
    private final Node tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void put(int key, int data) {
        Node value = keyValueMap.get(key);
        if (value == null) {
            Node node = new Node();
            node.key = key;
            node.value = data;

            keyValueMap.put(key, node);

            addInHead(node);
            size++;

            if (size > capacity) {
                Node removeNode = popTrail();
                keyValueMap.remove(removeNode.key);
                size--;
            }
        } else {
            value.value = data;
            moveToHead(value);
        }
    }

    public int get(int key) {
        Node node = keyValueMap.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    private void addInHead(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // Esse nó já existe e já tem uma ligação
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private Node popTrail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addInHead(node);
    }
}

/*
LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.



Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4


Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
* */

