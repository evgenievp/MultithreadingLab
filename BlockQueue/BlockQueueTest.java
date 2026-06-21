package com.BlockQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockQueueTest {

    @Test
    void addOrderShouldIncreaseStorageSize() {
        StorageClass storage = new StorageClass(10);

        Order order = new Order("Bikes", 6);

        boolean added = storage.addEl(order);

        assertTrue(added);
        assertEquals(1, storage.size());
    }

    @Test
    void consumeOrderShouldRemoveOrderFromStorage() {
        StorageClass storage = new StorageClass(10);

        Order order = new Order("Toys", 4);
        storage.addEl(order);

        Order consumed = storage.consumeEl();

        assertNotNull(consumed);
        assertEquals("Toys", consumed.getType());
        assertEquals(4, consumed.getQuantity());
        assertEquals(0, storage.size());
    }

    @Test
    void consumeFromEmptyStorageShouldReturnNull() {
        StorageClass storage = new StorageClass(10);

        Order consumed = storage.consumeEl();

        assertNull(consumed);
        assertEquals(0, storage.size());
    }

    @Test
    void addOrderShouldFailWhenStorageIsFull() {
        StorageClass storage = new StorageClass(1);

        boolean firstAdded = storage.addEl(new Order("Books", 3));
        boolean secondAdded = storage.addEl(new Order("Shoes", 2));

        assertTrue(firstAdded);
        assertFalse(secondAdded);
        assertEquals(1, storage.size());
    }
}