package scrollissue.rahul.com.scrollissue;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hadoop on 17/4/16.
 */
public class FragmentOne extends Fragment {

    String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",};

    private ViewPager vp = null;
    private RecyclerView rv;
    private TabLayout tabLayout;
    private int actionBarHeight;
    private LinearLayout ll;
    private GridLayoutManager scrollable;
    private GridLayoutManager notScrollable;
    private LinearLayout overlay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);

        rv = (RecyclerView) view.findViewById(R.id.recycle);
        tabLayout = (TabLayout) getActivity().findViewById(R.id.tab);
        vp = (ViewPager) getActivity().findViewById(R.id.viewpager);
        //overlay = (LinearLayout) getActivity().findViewById(R.id.overlay);

//        overlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        scrollable = new GridLayoutManager(getActivity(), 2) {
//            @Override
//            public boolean canScrollVertically() {
//                return true;
//            }
//        };
//
//        notScrollable = new GridLayoutManager(getActivity(), 2) {
//            @Override
//            public boolean canScrollVertically() {
//                return false;
//            }
//        };

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity());
        rv.setLayoutManager(scrollable);
        rv.setAdapter(adapter);

//        TypedValue tv = new TypedValue();
//        if (getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
//            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
//        }
//
//        ll = (LinearLayout) view.findViewById(R.id.padding);
//        ViewGroup.LayoutParams vg = ll.getLayoutParams();
//        vg.height = actionBarHeight;
//        vg.width = 1;
//        ll.setLayoutParams(vg);
//
//        ll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity().getApplicationContext(), "Padding clicked", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        ll.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });
//
//        vp.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getY() < actionBarHeight) {
//                    TabLayout tl = (TabLayout) getActivity().findViewById(R.id.tab);
//                    tl.dispatchTouchEvent(event);
//                }
//                return true;
//            }
//        });
//
//        overlay.setOnTouchListener(new View.OnTouchListener() {
//            int y = 0;
//            int distance = 0;
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                ViewGroup.LayoutParams vg;
//
//                if(vg.height==0){
//                    distance = (int) (y - event.getY());
//                    if(distance>0) {
//                        rv.dispatchTouchEvent(event);
//                        return true;
//                    }
//                }

//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        y = (int) event.getY();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        distance = (int) (y - event.getY());
//
//                        vg = ll.getLayoutParams();
//                        if(vg.height==0 && distance>0){
//                            rv.dispatchTouchEvent(event);
//                            return false;
//                        }
//
//                        if (distance > 0) {
//                            vg.height -= distance;
//                            if (vg.height < 0)
//                                vg.height = 0;
//                            if (vg.height == 0) {
//                                rv.setLayoutManager(scrollable);
//                            }
//                        } else if (distance < 0) {
//                            if (vg.height == actionBarHeight) {
//                                vg.height = actionBarHeight;
//                            } else {
//                                vg.height -= distance;
//                                if (vg.height > actionBarHeight)
//                                    vg.height = actionBarHeight;
//                            }
//                        }
//                        Log.i("LL Height", "" + distance);
//                        ll.setLayoutParams(vg);
//
//                        break;
//                }
//                Log.i("Touch", event.getY() + "");
//                return true;
//            }
//        });

        return view;
    }

    public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {
        private Context mContext;

        public MyRecyclerAdapter(Context context) {
            this.mContext = context;
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            protected TextView textView;

            public CustomViewHolder(View view) {
                super(view);
                this.textView = (TextView) view.findViewById(R.id.textview);
            }
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);

            CustomViewHolder viewHolder = new CustomViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {

            customViewHolder.textView.setText(str[i]);
            customViewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity().getApplicationContext(), "ASDASD", Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return str.length;
        }
    }
}
