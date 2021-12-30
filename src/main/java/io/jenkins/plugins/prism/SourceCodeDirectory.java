package io.jenkins.plugins.prism;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import edu.umd.cs.findbugs.annotations.NonNull;

import org.kohsuke.stapler.DataBoundConstructor;
import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;

/**
 * Approved directory that contains source code files that can be shown in Jenkins´ user interface.
 *
 * @author Ullrich Hafner
 */
public final class SourceCodeDirectory extends AbstractDescribableImpl<SourceCodeDirectory> implements Serializable {
    private static final long serialVersionUID = -3864564528382064924L;

    private final String path;

    /**
     * Creates a new instance of {@link SourceCodeDirectory}.
     *
     * @param path
     *         the name of the directory
     */
    @DataBoundConstructor
    public SourceCodeDirectory(final String path) {
        super();

        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SourceCodeDirectory that = (SourceCodeDirectory) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    /**
     * Descriptor to validate {@link SourceCodeDirectory}.
     *
     * @author Ullrich Hafner
     */
    @Extension
    public static class DescriptorImpl extends Descriptor<SourceCodeDirectory> {
        @NonNull
        @Override
        public String getDisplayName() {
            return StringUtils.EMPTY;
        }
    }
}

