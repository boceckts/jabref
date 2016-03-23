package net.sf.jabref.gui.help;

import com.airhacks.afterburner.views.FXMLView;
import net.sf.jabref.logic.l10n.Localization;

public class AboutDialogView extends FXMLView {

    public AboutDialogView() {
        super();
        bundle = Localization.getMessages();
    }
}
