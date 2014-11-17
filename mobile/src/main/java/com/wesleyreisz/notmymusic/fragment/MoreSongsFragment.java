package com.wesleyreisz.notmymusic.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wesleyreisz.notmymusic.R;

/**
 * Created by wesleyreisz on 10/27/14.
 */
public class MoreSongsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_more_songs, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = (TextView)getActivity().findViewById(R.id.textViewMoreSongs);
        textView.setText("Bacon ipsum dolor amet corned beef pork chop kielbasa brisket t-bone pork belly swine meatloaf doner andouille ribeye jowl tri-tip tongue bresaola. Pancetta porchetta frankfurter filet mignon leberkas t-bone, brisket hamburger biltong short ribs rump tongue. Ball tip picanha landjaeger alcatra. Meatloaf kielbasa shankle meatball swine, jerky bresaola corned beef tail drumstick. Sirloin short ribs chicken ball tip. Doner kevin kielbasa pastrami tongue prosciutto cow sirloin frankfurter ball tip alcatra chicken ground round. Boudin pork loin turkey bresaola.\n" +
                "\n" +
                "Meatball corned beef shank prosciutto strip steak doner capicola chuck pork chop filet mignon andouille pork belly ham hock. Swine fatback pancetta andouille jowl beef ribs. Ground round biltong drumstick spare ribs, turducken pig strip steak leberkas bresaola ribeye alcatra cow beef ribs picanha. Rump landjaeger bacon ham hock spare ribs short ribs.\n" +
                "\n" +
                "Bacon beef ribs strip steak fatback turducken, ball tip porchetta jowl pancetta shoulder drumstick capicola. Shank flank spare ribs bacon t-bone. Flank jerky ball tip capicola andouille filet mignon. Jowl ground round bacon turkey flank, frankfurter sirloin tail tongue swine tenderloin shankle chuck kevin beef ribs. Pig sausage prosciutto beef. Fatback ball tip frankfurter beef chuck t-bone cow, kielbasa beef ribs boudin brisket prosciutto doner ribeye. T-bone bresaola chuck, rump cow leberkas landjaeger.");

    }
}
