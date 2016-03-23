/*  Copyright (C) 2003-2015 JabRef contributors.
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/
package net.sf.jabref.gui.help;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import net.sf.jabref.JabRef;
import net.sf.jabref.gui.FXAlert;
import net.sf.jabref.gui.actions.MnemonicAwareAction;
import net.sf.jabref.logic.l10n.Localization;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AboutAction extends MnemonicAwareAction {

    private final Log logger = LogFactory.getLog(AboutAction.class);

    public AboutAction(String title, String tooltip, Icon iconFile) {
        super(iconFile);
        putValue(Action.NAME, title);
        putValue(Action.SHORT_DESCRIPTION, tooltip);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Platform.runLater(
                () -> {
                    FXAlert aboutDialog = new FXAlert(Alert.AlertType.INFORMATION, Localization.lang("About JabRef"));

                    AboutDialogView view = new AboutDialogView();
                    aboutDialog.setDialogPane((DialogPane) view.getView());

                    // TODO: Find better solution for icon loading (css?)
                    try (InputStream imageStream = JabRef.class.getResourceAsStream("/images/external/JabRef-icon-48.png");) {
                        Image jabRefIcon = new Image(imageStream);
                        aboutDialog.setDialogIcon(jabRefIcon);
                    } catch (IOException ex) {
                        logger.debug("Could not load jabref icon", ex);
                    }

                    aboutDialog.show();
                });
    }
}
