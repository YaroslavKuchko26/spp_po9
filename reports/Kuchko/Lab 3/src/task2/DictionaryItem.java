package org.example;

import java.util.Objects;

public class DictionaryItem {

    private String valueRu;
    private String valueEn;
    private Integer requestsAmount;

    public DictionaryItem() {
    }

    public DictionaryItem(String valueRu, String valueEn, Integer requestsAmount) {
        this.valueRu = valueRu;
        this.valueEn = valueEn;
        this.requestsAmount = requestsAmount;
    }

    public String getValueRu() {
        return valueRu;
    }

    public void setValueRu(String valueRu) {
        this.valueRu = valueRu;
    }

    public String getValueEn() {
        return valueEn;
    }

    public void setValueEn(String valueEn) {
        this.valueEn = valueEn;
    }

    public Integer getRequestsAmount() {
        return requestsAmount;
    }

    public void setRequestsAmount(Integer requestsAmount) {
        this.requestsAmount = requestsAmount;
    }

    @Override
    public String toString() {
        return "\nDictionaryItem{" +
                "valueRu='" + valueRu + '\'' +
                ", valueEn='" + valueEn + '\'' +
                ", requestsAmount=" + requestsAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryItem that = (DictionaryItem) o;
        return Objects.equals(valueRu, that.valueRu) && Objects.equals(valueEn, that.valueEn) && Objects.equals(requestsAmount, that.requestsAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueRu, valueEn, requestsAmount);
    }
}
