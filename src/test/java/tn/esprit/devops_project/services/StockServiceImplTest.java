package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {
    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @Test
    void addStock() {
        Stock stock = new Stock();
        stock.setIdStock(1L);
        stock.setTitle("Sample Stock");
        stock.setProducts(new HashSet<>());

        when(stockRepository.save(any(Stock.class))).thenReturn(stock);

        Stock savedStock = stockService.addStock(stock);

        assertNotNull(savedStock);
        assertEquals(1L, savedStock.getIdStock());
        assertEquals("Sample Stock", savedStock.getTitle());

    }
}