package life.vishalsingh.ModuleC;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapterTabLayout extends FragmentStatePagerAdapter {
    private static int NUM_TABS = 3;

    public PagerAdapterTabLayout(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new TabLayoutFragment1();
            case 1: return new TabLayoutFragment2();
            case 2: return new TabLayoutFragment3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }
}
