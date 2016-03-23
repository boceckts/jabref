package net.sf.jabref.gui.help;

import com.airhacks.afterburner.injection.Injector;
import net.sf.jabref.logic.util.BuildInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AboutDialogViewModelTest {

    @Mock BuildInfo buildInfo;

    @InjectMocks AboutDialogViewModel viewModel;

    @Test
    public void startYearRangeWith2003() {
        when(buildInfo.getYear()).thenReturn("2020");

        viewModel.initialize();
        assertEquals("2003-2020", viewModel.getYears());
    }
}