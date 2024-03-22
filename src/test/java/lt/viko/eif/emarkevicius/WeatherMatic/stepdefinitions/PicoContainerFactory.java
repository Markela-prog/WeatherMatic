package lt.viko.eif.emarkevicius.WeatherMatic.stepdefinitions;

import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;

public class PicoContainerFactory implements ObjectFactory {
    private final PicoFactory delegate = new PicoFactory();

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> glueClass) {
        delegate.addClass(glueClass);
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> glueClass) {
        return delegate.getInstance(glueClass);
    }
}
