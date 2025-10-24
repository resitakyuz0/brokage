package com.ing.brokage;

import com.ing.brokage.asset.Asset;
import com.ing.brokage.asset.AssetRepository;
import com.ing.brokage.asset.AssetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssetServiceTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private AssetService assetService;

    @Test
    void shouldReturnUserWhenIdExists() {
        Asset mockAsset = new Asset(1L, "TRY",1000.00);
        when(assetRepository.findById(1L)).thenReturn(Optional.of(mockAsset));

        Asset result = assetService.findById(1L);

        assertEquals("TRY", result.getAssetName());
        verify(assetRepository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenAssetNotFound() {
        when(assetRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> assetService.findById(99L));

        assertEquals("Could not find asset " + 99, exception.getMessage());
    }

    @Test
    void shouldCreateAssetSuccessfully() {
        Asset savedAsset = new Asset(99L, "TRY",1000.00);
        when(assetRepository.save(any(Asset.class))).thenReturn(savedAsset);

        Asset asset = assetService.save(new Asset(99L, "TRY",1000.00));

        assertEquals("TRY", asset.getAssetName());
        verify(assetRepository).save(any(Asset.class));
    }
}
