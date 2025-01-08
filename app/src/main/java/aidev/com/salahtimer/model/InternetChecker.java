package aidev.com.salahtimer.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;

import androidx.annotation.NonNull;

public class InternetChecker {
    private final ConnectivityManager connectivityManager;
    private final ConnectivityManager.NetworkCallback networkCallback;
    private NetworkStateListener networkStateListener;

    public InternetChecker(Context context) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@NonNull Network network) {
                if (networkStateListener != null) {
                    networkStateListener.onNetworkAvailable();
                }
            }

            @Override
            public void onLost(@NonNull Network network) {
                if (networkStateListener != null) {
                    networkStateListener.onNetworkLost();
                }
            }

            @Override
            public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
                boolean hasInternet = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
                if (networkStateListener != null) {
                    networkStateListener.onInternetCapabilityChanged(hasInternet);
                }
            }
        };
    }

    public void setNetworkStateListener(NetworkStateListener listener) {
        this.networkStateListener = listener;
    }

    public void startMonitoring() {
        NetworkRequest networkRequest = new NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build();
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback);
    }

    public void stopMonitoring() {
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }

    public interface NetworkStateListener {
        void onNetworkAvailable();

        void onNetworkLost();

        void onInternetCapabilityChanged(boolean hasInternet);
    }
}
