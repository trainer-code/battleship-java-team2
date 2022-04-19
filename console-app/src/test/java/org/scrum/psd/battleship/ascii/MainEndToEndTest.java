package org.scrum.psd.battleship.ascii;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.extension.ExtendWith;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemIn;

import java.util.stream.Collectors;

import uk.org.webcompere.systemstubs.stream.SystemOut;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;

@ExtendWith(SystemStubsExtension.class)
class MainEndToEndTest {

    @SystemStub
    private SystemOut systemOut;


    @Test
    public void testPlayGameShotHits() throws Exception{
        try {

            withTextFromSystemIn("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "c1", "c2", "c3",
                    "d1", "d2",
                    "d3", "e1", "e2", "b4").execute(() -> {
                       Main.main(new String[] {});
                    });

        } catch (NoSuchElementException e) {
            var lines = systemOut.getLines().map(elem -> new String(elem)).collect(Collectors.toList());
            assertThat(lines, (hasItem(containsString("Welcome to Battleship"))));
            assertThat(lines, (hasItem(containsString("Yeah ! Nice hit !"))));

        }
    }

    @Test
    public void testPlayGameShotMisses() {
        try {

            withTextFromSystemIn("a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "c1", "c2", "c3", "d1", "d2",
                    "d3", "e1", "e2", "e4").execute(() -> {
                        Main.main(new String[] {});
                    });

        } catch (NoSuchElementException e) {
            var lines = systemOut.getLines().map(elem -> new String(elem)).collect(Collectors.toList());
            assertThat(lines, (hasItem(containsString("Welcome to Battleship"))));
            assertThat(lines, (hasItem(containsString("Miss"))));

        } catch (Exception e) {

        }

    }
}
