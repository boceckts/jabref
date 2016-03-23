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

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.Initializable;
import net.sf.jabref.logic.util.BuildInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.sf.jabref.Globals;
import net.sf.jabref.JabRef;
import net.sf.jabref.gui.ClipBoardManager;
import net.sf.jabref.gui.desktop.JabRefDesktop;
import net.sf.jabref.logic.l10n.Localization;

import javax.inject.Inject;

public class AboutDialogViewModel {

    private final Log logger = LogFactory.getLog(AboutDialogViewModel.class);
    private final ReadOnlyStringWrapper website = new ReadOnlyStringWrapper();
    private final ReadOnlyStringWrapper websiteLibraries = new ReadOnlyStringWrapper();
    private final ReadOnlyStringWrapper websiteGithub = new ReadOnlyStringWrapper();
    private final ReadOnlyStringWrapper header = new ReadOnlyStringWrapper();
    private final ReadOnlyStringWrapper years = new ReadOnlyStringWrapper();
    private final ReadOnlyStringWrapper authors = new ReadOnlyStringWrapper();
    private final ReadOnlyStringWrapper developers = new ReadOnlyStringWrapper();
    @Inject protected BuildInfo buildInfo;
    @FXML private Button closeButton;

    @FXML
    public void initialize() {
        website.set("http://www.jabref.org");
        websiteLibraries.set("https://github.com/JabRef/jabref/blob/master/external-libraries.txt");
        websiteGithub.set("https://github.com/JabRef/jabref");

        header.set(String.format("JabRef %s", buildInfo.getVersion()));
        years.set(String.format("2003-%s", buildInfo.getYear()));
        developers.set(buildInfo.getDevelopers());
        authors.set(buildInfo.getAuthors());
    }

    public String getWebsite() {
        return website.get();
    }

    public ReadOnlyStringProperty websiteProperty() {
        return website.getReadOnlyProperty();
    }

    public String getWebsiteLibraries() {
        return websiteLibraries.get();
    }

    public ReadOnlyStringProperty websiteLibrariesProperty() {
        return websiteLibraries.getReadOnlyProperty();
    }

    public String getWebsiteGithub() {
        return websiteGithub.get();
    }

    public ReadOnlyStringProperty websiteGithubProperty() {
        return websiteGithub.getReadOnlyProperty();
    }

    public String getHeader() {
        return header.get();
    }

    public ReadOnlyStringProperty headerProperty() {
        return header.getReadOnlyProperty();
    }

    public String getYears() {
        return years.get();
    }

    public ReadOnlyStringProperty yearsProperty() {
        return years.getReadOnlyProperty();
    }

    public String getAuthors() {
        return authors.get();
    }

    public ReadOnlyStringProperty authorsProperty() {
        return authors.getReadOnlyProperty();
    }

    public String getDevelopers() {
        return developers.get();
    }

    public ReadOnlyStringProperty developersProperty() {
        return developers.getReadOnlyProperty();
    }

    @FXML
    private void closeAboutDialog() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void copyVersionToClipboard() {
        ClipBoardManager.CLIPBOARD.setClipboardContents(buildInfo.getVersion());
        String message = String.format("%s - %s", Localization.lang("Copy version"), buildInfo.getVersion());
        JabRef.jrf.output(message);
    }

    @FXML
    private void openJabrefWebsite() {
        try {
            JabRefDesktop.openBrowser(getWebsite());
        } catch (IOException e) {
            JabRef.jrf.output(Localization.lang("Error") + ": " + e.getLocalizedMessage());
            logger.debug("Could not open default browser.", e);
        }
    }

    @FXML
    private void openExternalLibrariesWebsite() {
        try {
            JabRefDesktop.openBrowser(getWebsiteLibraries());
        } catch (IOException e) {
            JabRef.jrf.output(Localization.lang("Error") + ": " + e.getLocalizedMessage());
            logger.debug("Could not open default browser.", e);
        }
    }

    @FXML
    private void openGithub() {
        try {
            JabRefDesktop.openBrowser(getWebsiteGithub());
        } catch (IOException e) {
            JabRef.jrf.output(Localization.lang("Error") + ": " + e.getLocalizedMessage());
            logger.debug("Could not open default browser.", e);
        }
    }

}
