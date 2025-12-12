package de.seuhd.campuscoffee.domain.model.objects;

import lombok.Builder;
import lombok.NonNull;


import jakarta.annotation.Nullable;

/**
 * Domain record that stores a review for a point of sale.
 * Reviews are approved once they received a configurable number of approvals.
 */
@Builder(toBuilder = true)
public record Review(
        @Nullable Long id, // null when the review has not been created yet
        //TODO: Implement review domain model.
        @NonNull Pos pos,
        @NonNull User author,
        @NonNull String review,
        @NonNull Integer approvalCount,
        @NonNull Boolean approved     // is updated by the domain module
) implements DomainModel<Long> {
    @Override
    public Long getId() {
        return id;
    }
    public boolean isApproved(int requiredApprovals) {
        return approvalCount >= requiredApprovals;
    }
}