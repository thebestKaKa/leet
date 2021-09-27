package algorithms.search_third;

import java.util.Objects;

public class LinearProbingHashST<Key, Value> {
    //线性探测哈希表
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(){
        keys = (Key[])new Objects[M];
        values = (Value[])new Objects[M];
        this.N = 0;
    }

    public LinearProbingHashST(int cap){
        keys = (Key[])new Objects[cap];
        values = (Value[])new Objects[cap];
        this.M = cap;
        this.N = 0;
    }

    private void resize(int cap){
        LinearProbingHashST<Key, Value> st = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) st.put(keys[i], values[i]);
        }
        //？
        this.keys = st.getKeys();
        this.values = st.getValues();
        this.M = st.getM();
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;//这里需做素数预处理
    }

    public void put(Key key, Value value){
        if (2 * N >= M)resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M){
            if (keys[i].equals(key)){values[i] = value;return;}
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key){
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key))return values[i];
        }
        return null;
    }

    public void delete(Key key){
        int i = hash(key);
        while (!keys[i].equals(key)){
            i = (i + 1) % M;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null){
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;//先减去可以省去可能的数组resize

            put(keyToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && 8 * N <= M)resize(M/2);
    }

    public Key[] getKeys(){
        return this.keys;
    }

    public Value[] getValues(){
        return this.values;
    }

    public int getM(){
        return this.M;
    }
}
