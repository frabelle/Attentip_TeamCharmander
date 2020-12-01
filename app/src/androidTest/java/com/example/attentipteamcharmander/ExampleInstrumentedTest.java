package com.example.attentipteamcharmander;

import android.content.Context;
import android.text.TextUtils;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.List;

import com.example.attentipteamcharmander.data.EjerciciosAssetSource;
import com.example.attentipteamcharmander.models.Categoria;
import com.example.attentipteamcharmander.models.CategoriasResult;
import com.example.attentipteamcharmander.models.Ejercicio;
import com.example.attentipteamcharmander.models.SubCategoria;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void dado_obtenerTodosLosDatos_sinParams_convertirTodoOk() {
        EjerciciosAssetSource dataSource = new EjerciciosAssetSource(getAppContext());
        final CategoriasResult result = dataSource.obtenerCategorias();
        assertNotNull(result);

        final List<Categoria> categorias = result.getCategorias();
        assertNotNull(categorias);
        assertFalse(categorias.isEmpty());

        for (Categoria categoria : categorias) {
            assertFalse(TextUtils.isEmpty(categoria.getNombre()));
            assertNotNull(categoria.getSubCategorias());

            final List<SubCategoria> subCategoriasDeCategoria = categoria.getSubCategorias();
            for (SubCategoria subCategoria : subCategoriasDeCategoria) {
                assertFalse(TextUtils.isEmpty(subCategoria.getNombre()));
                assertNotNull(subCategoria.getEjercicios());

                final List<Ejercicio> ejerciciosDeSubCategoria = subCategoria.getEjercicios();

                for (Ejercicio ejercicio : ejerciciosDeSubCategoria) {
                    assertFalse(TextUtils.isEmpty(ejercicio.getNombre()));
                    assertFalse(TextUtils.isEmpty(ejercicio.getDescripcion()));
                }
            }
        }
    }

    private Context getAppContext() {
        return InstrumentationRegistry.getInstrumentation().getTargetContext();
    }
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.attentipteamcharmander", appContext.getPackageName());
    }
}